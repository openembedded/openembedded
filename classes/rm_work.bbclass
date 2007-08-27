#
# Removes source after build
#
# To use it add that line to conf/local.conf:
#
# INHERIT += "rm_work"
#

RMWORK_ORIG_TASK := "${BB_DEFAULT_TASK}"
BB_DEFAULT_TASK = "rm_work_all"

do_rm_work () {
    cd ${WORKDIR}
    for dir in *
    do
        if [ `basename ${S}` = $dir ]; then
            rm -rf $dir
        elif [ $dir != 'temp' ]; then
            rm -rf $dir
        fi
    done
}
# Uncomment me when we can use bitbake 1.8.8
#addtask rm_work after do_${RMWORK_ORIG_TASK}
addtask rm_work after do_build

do_rm_work_all () {
	:
}
do_rm_work_all[recrdeptask] = "do_rm_work"
addtask rm_work_all after do_rm_work
