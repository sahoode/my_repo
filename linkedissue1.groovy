import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.comments.Comment
import com.atlassian.jira.issue.comments.CommentManager
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.link.IssueLink
import com.atlassian.jira.issue.link.IssueLinkManager
import com.atlassian.jira.user.ApplicationUser

Issue issue = event.issue
Comment comment = event.comment

CommentManager commentManager = ComponentAccessor.getCommentManager()
IssueLinkManager issueLinkManager = ComponentAccessor.getIssueLinkManager()
ApplicationUser loggedInUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()

String commentBody = comment.getBody()

issueLinkManager.getOutwardLinks(issue.getId()).each {IssueLink issueLink ->
    commentManager.create(issueLink.getDestinationObject(), loggedInUser, commentBody, false)
}

issueLinkManager.getInwardLinks(issue.getId()).each {IssueLink issueLink ->
    commentManager.create(issueLink.getSourceObject(), loggedInUser, commentBody, false)
}