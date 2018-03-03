<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
    </div>
    <form role="form" name="task" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="number" type="hidden" name="id" value="${task.id}"/>
        <div>
            <label for="issue_name">Issue Name</label>
            <input type="issue_name" class="form-control" name="issue_name" id="issue_name" value="${task.issue_name}"/>
        </div>
        <div>
            <label for="issue_status">Issue Status</label>
            <input type="issue_status" name="issue_status" id="issue_status" value="${task.issue_status}"/>
        </div>
        <div>
            <label for="issue_report_date">Report Date</label>
            <input type="issue_report_date" name="issue_report_date" id="issue_report_date"  value="${task.issue_report_date}"/>
        </div>
        <div>
            <label for="issue_update_date">Update Date</label>
            <input type="issue_update_date" name="issue_update_date" id="issue_update_date"  value="${task.issue_update_date}" />
        </div>

        <div>
            <label for="issue_heading">Heading</label>
            <input type="issue_heading"  name="issue_heading" id="issue_heading" value="${task.issue_heading}"/>
        </div>
        <div>
            <label for="issue_description">Description</label>
            <input type="issue_description"  name="issue_description" id="issue_description" value="${task.issue_description}"/>
        </div>
        <div>
            <label for="issue_linked_with">Linked Issue</label>
            <input type="issue_linked_with" name="issue_linked_with" id="issue_linked_with" value="${task.issue_linked_with}" />
        </div>
		<div>
            <label for="issue_comments">Comments</label>
            <input type="issue_comments"  name="issue_comments" id="issue_comments" value="${task.issue_comments}"/>
        </div>
        <div>
            <label for="issue_others">Other details</label>
            <input type="issue_others"  name="issue_others" id="issue_others" value="${task.issue_others}"/>
        </div>
        <div>
            <label for="issue_closed">Issue Close date</label>
            <input type="issue_closed"  name="issue_closed" id="issue_closed" value="${task.issue_closed}"/>
        </div>
        <div>
            <label for="issue_type">Issue Type</label>
            <input type="issue_type"  name="issue_type" id="issue_type" value="${task.issue_type}"/>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
