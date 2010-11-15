python do_checkbashisms () {
    import re
    import oe.process
    import oe.path

    def readline(path):
        try:
            return iter(open(path, "r")).next()
        except StopIteration:
            pass

    shebang = re.compile("^#! */bin/sh$")
    errors = False
    srcdir = d.getVar("S", True)
    for path in oe.path.find(srcdir):
        line = readline(path)
        if line and shebang.match(line):
            try:
                output = oe_run(d, ["checkbashisms", path])
            except oe.process.ExecutionError, exc:
                if not errors:
                    errors = True
                bb.note(str(exc))
            except oe.process.NotFoundError, exc:
                bb.fatal("checkbashisms not found, please install it in your PATH")

    if errors:
        bb.fatal("bashisms were identified, aborting")
}
addtask checkbashisms after do_patch

do_checkbashisms_all[recrdeptask] = "do_checkbashisms"
do_checkbashisms_all[nostamp] = "1"
addtask checkbashisms_all after do_checkbashisms
