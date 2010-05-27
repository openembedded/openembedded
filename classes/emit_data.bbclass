# Emit the datastore to a file, and if it was previously emitted, display the
# differences to the user.

EMIT_DIR = "${TMPDIR}/emit-data"
EMIT_BLACKLIST += "BUILDSTART DATE TIME DATETIME \
                   __* _  PWD \
                   DISPLAY XDG_SESSION_COOKIE \
                   SSH_AUTH_SOCK SSH_TTY SSH_CLIENT SSH_CONNECTION \
                   SESSION_MANAGER DESKTOP_SESSION COLORTERM TERM \
                   XAUTHORITY GTK_RC_FILES DBUS_SESSION_BUS_ADDRESS \
                   GREP_OPTIONS \
                   GNOME_KEYRING GNOME_KEYRING_PID"

def diff_datadict(d, old_data, data):
    from itertools import chain
    from difflib import Differ
    from fnmatch import fnmatchcase

    blacklist = d.getVar("EMIT_BLACKLIST", True).split()

    keys = sorted(set(chain(old_data.iterkeys(), data.iterkeys())))
    keys = [key for key in keys
            if not any(fnmatchcase(key, pat) for pat in blacklist)]

    old = ["%s: %s\n" % (key, old_data.get(key)) for key in keys]
    new = ["%s: %s\n" % (key, data.get(key)) for key in keys]
    return Differ().compare(old, new)


python do_emit_data () {
    import pickle

    data = dict((key, repr(d.getVar(key, False))) for key in d.keys())
    outfile = os.path.join(d.getVar("EMIT_DIR", True), d.getVar("PF", True))
    bb.mkdirhier(os.path.dirname(outfile))
    if os.path.exists(outfile):
        f = open(outfile, "rb")
        old_data = pickle.load(f)
        f.close()

        diff = diff_datadict(d, old_data, data)
        differences = [line for line in diff if not line.startswith(" ")]
        if differences:
            bb.note(bb.data.expand("${PF}: data has changed:", d))
            for line in differences:
                bb.note(line.rstrip())

    pickle.dump(data, open(outfile, "wb"))
}
do_emit_data[nostamp] = "1"
addtask emit_data

do_emit_data_all[recrdeptask] = "do_emit_data"
do_emit_data_all[nostamp] = "1"
addtask emit_data_all after do_emit_data
