# RestAssuredProject
*************Source code in master branch. If by default master brunch is not selected please change it*************

Rest Assured Automation for Practice Purpose

<span style="background-color: #FFFF00">1. Faced Problem: During git push</span>

! [rejected]        master -> master (non-fast-forward)
error: failed to push some refs to 'git@github.com:asantoya/projectnewbies.git'
To prevent you from losing history, non-fast-forward updates were rejected
Merge the remote changes (e.g. 'git pull') before pushing again.  See the
'Note about fast-forwards' section of 'git push --help' for details.
> Reason: I added readme file from github GUI. This readme file was not uptodate on local. While trying to push my changes from local got this error. If remote and local is not matched will get this error.
> Solution: I did git fetch and then git pull origin master --allow-unrelated-histories and pushed the changes it worked. Can possible to do force push but it will destroy all the changes on remote which I dont have on local branch.
Note: When push with this command(git push -u origin master) local branch autometically linked with remote branch.  
