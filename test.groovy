import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.ModifiedValue
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.user.util.UserManager
import com.atlassian.jira.event.type.EventDispatchOption
import com.opensymphony.workflow.InvalidInputException
import com.atlassian.jira.issue.customfields.option.Option
import com.atlassian.jira.issue.customfields.view.CustomFieldParams
import com.atlassian.jira.issue.customfields.impl.CascadingSelectCFType


//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("C2CT-20035")
//Issue issueIM  = issue   

   // CustomField technolog = ComponentAccessor.getCustomFieldManager().getCustomFieldObject("customfield_10707")
   // def value_a = issue.getCustomFieldValue(technolog)
//            .setAssignee(value_a)
//            def assignee = issue.getAssignee()
                                
                
//return assignee
IssueManager im = ComponentAccessor.getIssueManager()
MutableIssue issue = im.getIssueObject("C2CT-20035")
CustomField technolog = ComponentAccessor.getCustomFieldManager().getCustomFieldObject("customfield_10707")

// the username of the assignee
def String userName = issue.getCustomFieldValue(technolog)

def user = ComponentAccessor.userManager.getUserIdentityByUsername(userName)
issue.setAssignee(userName)
def assignee = issue.getAssignee()

return userName
