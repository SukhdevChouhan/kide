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
        <li><a href="/task/create">Create Task</a></li>
        <li><a href="/tasks">My Tasks</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
    </div>
    <form role="form" name="editTask" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    	 <div>
            <label for="id">Issue id</label>
            <input type="id" class="form-control" name="id" id="id" value="${task.id?long?c}"/>
        </div>
        <div>
            <label for="issue_name">Issue Name</label>
            <input type="issue_name" class="form-control" name="issue_name" id="issue_name" value="${task.issue_name}"/>
        </div>
        <div>
            <label for="issue_status">Issue Status</label>
            <select name="issue_status" id="issue_status">
            <option value = "${task.issue_status}">${task.issue_status}</option>
            <option value = "submitted">Submitted</option>
            <option value = "active">Active</option>
            <option value = "completed">Completed</option>
            <option value = "defer">Defer</option>
            <option value = "working_as_designed">Working as designed</option>
         </select>
        </div>
        <div>
            <label for="issue_report_date">Report Date</label>
            <input type="date" name="issue_report_date" id="issue_report_date"  value="${task.issue_report_date}"/>
        </div>
        <div>
            <label for="issue_update_date">Update Date</label>
            <input type="date" name="issue_update_date" id="issue_update_date"  value="${task.issue_update_date}" />
        </div>

        <div>
            <label for="issue_heading">Heading</label>
            <textarea rows="1" cols="70"  name="issue_heading" id="issue_heading" value="${task.issue_heading}">
            ${task.issue_heading}</textarea>
        </div>
        <div>
            <label for="issue_description">Description</label>
            <textarea rows="4" cols="50"  name="issue_description" id="issue_description" value="${task.issue_description}">
            ${task.issue_description}</textarea>
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
            <input type="date"  name="issue_closed" id="issue_closed" value="${task.issue_closed}"/>
        </div>
        <div>
            <label for="issue_type">Issue Type</label>
            <select name="issue_type" id="issue_type">
            <option value = "${task.issue_type}">${task.issue_type}</option>
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
