<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>
test git after creating release branch
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/tasks">My Tasks</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
        <center>   <h3>ISSUE CREATION FORM</h3></center>
    </div>
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="issue_name">Issue Name</label>
            <input type="issue_name" class="form-control" name="issue_name" id="issue_name" value="VM-"
                    autofocus placeholder="Issue Name"/>
        </div>
        <div>
            <label for="issue_status">Issue Status</label>
            <select name="issue_status" id="issue_status">
            <option value = "submitted">Submitted</option>
            <option value = "active">Active</option>
            <option value = "completed">Completed</option>
            <option value = "defer">Defer</option>
            <option value = "working_as_designed">Working as designed</option>
         </select>
        </div>
        <div>
            <label for="issue_report_date">Report Date</label>
            <input type="date" name="issue_report_date" id="issue_report_date"  value="test"  placeholder="Report Date"/>
        </div>
        <div>
            <label for="issue_update_date">Update Date</label>
            <input type="date" name="issue_update_date" id="issue_update_date"  value="test" 
                   autofocus placeholder="Update Date"/>
        </div>

        <div>
            <label for="issue_heading">Heading</label>
            <input type="issue_heading"  name="issue_heading" id="issue_heading"  placeholder="issue heading"/>
        </div>
        <div>
            <label for="issue_description">Description</label>
            <input type="issue_description"  name="issue_description" id="issue_description"  autofocus placeholder="Description"/>
        </div>
        <div>
            <label for="issue_linked_with">Linked Issue</label>
            <input type="issue_linked_with" name="issue_linked_with" id="issue_linked_with"  autofocus placeholder="Linked Issue"/>
        </div>
		<div>
            <label for="issue_comments">Comments</label>
            <input type="issue_comments"  name="issue_comments" id="issue_comments"  placeholder="issue Comments"/>
        </div>
        <div>
            <label for="issue_others">Other details</label>
            <input type="issue_others"  name="issue_others" id="issue_others"  placeholder="Other Details"/>
        </div>
        <div>
            <label for="issue_closed">Issue Close date</label>
            <input type="date"  name="issue_closed" id="issue_closed" placeholder="issue Closed date"/>
        </div>
        <div>
            <label for="issue_type">Issue Type</label>
            <select name="issue_type" id="issue_type">
            <option value = "bug">bug</option>
            <option value = "task">task</option>
             <option value = "sub_task">sub-task</option>
            <option value = "epic">epic</option>
            <option value = "story">Story</option>
            <option value = "sub_story">Sub Story</option>
         </select>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>