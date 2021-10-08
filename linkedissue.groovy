import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.ModifiedValue
import com.atlassian.jira.issue.CustomFieldManager
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
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.link.IssueLink;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.fields.CustomField



IssueManager im = ComponentAccessor.getIssueManager();
MutableIssue issue = im.getIssueObject("AOSPR-24854");


def links = ComponentAccessor.getIssueLinkManager().getInwardLinks(issue.getId())
//def links = ComponentAccessor.getIssueLinkManager().getOutwardLinks(issue.getId())

//return links[0].getSourceObject()

def output = ""
def output1= ""
for( l in links) {
    
    //use this for Outward links
  output1 = output1 + l.issueLinkType.name + ": " +  l.getDestinationObject() + "<br/>"
   
    //use this for Inward links
  output = output + l.getSourceObject().getCustomFieldValue() + "<br/>"
    
}


//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("C2CT-20035")
Issue issueIM  = issue   

   // CustomField technolog = ComponentAccessor.getCustomFieldManager().getCustomFieldObject("customfield_10707")
   // def value_a = issue.getCustomFieldValue(technolog)
//            .setAssignee(value_a)
//            def assignee = issue.getAssignee()
                                
                

//IssueManager im = ComponentAccessor.getIssueManager()
//MutableIssue issue = im.getIssueObject("C2CT-20035")
CustomField technolog = ComponentAccessor.getCustomFieldManager().getCustomFieldObject("customfield_13400")

// the username of the assignee
def String value = issue.getCustomFieldValue(technolog)

return value