#
# Removes source after build
#
# To use it add that line to conf/local.conf:
#
# INHERIT += "rm_work"
#

# Use the completion scheulder by default when rm_work is active
# to try and reduce disk usage
BB_SCHEDULER ?= "completion"

RMWORK_ORIG_TASK := "${BB_DEFAULT_TASK}"
BB_DEFAULT_TASK = "rm_work_all"

do_rm_work () {
    cd ${WORKDIR}
    for dir in *
    do
        if [ `basename ${dir}` = "temp" ]; then
            echo "Not removing temp"
        else 
            echo "Removing $dir" ; rm $dir -rf		
        fi
    done
}
addtask rm_work after do_${RMWORK_ORIG_TASK}

do_rm_work_all () {
	:
}
do_rm_work_all[recrdeptask] = "do_rm_work"
addtask rm_work_all after do_rm_work


addhandler rmwork_stampfixing_eventhandler
python rmwork_stampfixing_eventhandler() {
    if bb.event.getName(e) == "StampUpdate":
        for (fn, task) in e.targets:
            if task == 'rm_work_all':
                continue
            stamp = "%s.do_rm_work" % e.stampPrefix[fn]
            if os.path.exists(stamp):
                dir = "%s.*" % e.stampPrefix[fn]
                bb.note("Removing stamps: " + dir)
                os.system('rm -f '+ dir)

    return NotHandled
}

