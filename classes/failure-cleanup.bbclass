# This class clean a package on failure, a nice way to keep diskspace usage down and force rebuilds

# we want to be an event handler
addhandler failure_eventhandler
python failure_eventhandler() {
    from bb import build, event, note, error, data
    from bb.event import getName

    if e.data is None or getName(e) == "MsgNote":
        return

    name = getName(e)
    if name == "PkgFailed":
       bb.note("Exectuting -c clean on failed build")
       build.exec_func('do_clean', e.data)
}
