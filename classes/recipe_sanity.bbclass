def incorrect_nonempty_PACKAGES(cfgdata, d):
    import bb.data
    if bb.data.inherits_class("native", d) or \
       bb.data.inherits_class("cross", d):
        if d.getVar("PACKAGES", 1):
            return True

def can_use_autotools_base(cfgdata, d):
    import bb
    cfg = d.getVar("do_configure", 1)
    if not bb.data.inherits_class("autotools", d):
        return False

    for i in ["autoreconf"] + ["%s_do_configure" % cls for cls in ["gnome", "e", "autotools", "autotools_stage", "efl", "gpephone", "openmoko", "openmoko2", "xfce", "xlibs"]]:
        if cfg.find(i) != -1:
            return False

    import os
    for clsfile in d.getVar("__inherit_cache", 0):
        (base, _) = os.path.splitext(os.path.basename(clsfile))
        if cfg.find("%s_do_configure" % base) != -1:
            bb.note("%s: recipe_sanity: autotools_base usage needs verification, spotted %s" % (d.getVar("P", 1), "%s_do_configure" % base))

    return True

def can_remove_FILESPATH(cfgdata, d):
    import os
    import bb
    expected = cfgdata.get("FILESPATH")
    #expected = "${@':'.join([os.path.normpath(os.path.join(fp, p, o)) for fp in d.getVar('FILESPATHBASE', 1).split(':') for p in d.getVar('FILESPATHPKG', 1).split(':') for o in (d.getVar('OVERRIDES', 1) + ':').split(':') if os.path.exists(os.path.join(fp, p, o))])}:${FILESDIR}"
    expectedpaths = bb.data.expand(expected, d)
    unexpanded = d.getVar("FILESPATH", 0)
    filespath = d.getVar("FILESPATH", 1).split(":")
    filespath = [os.path.normpath(f) for f in filespath if os.path.exists(f)]
    for fp in filespath:
        if not fp in expectedpaths:
            # bb.note("Path %s in FILESPATH not in the expected paths %s" % (fp, expectedpaths))
            return False
    return expected != unexpanded

def can_remove_FILESDIR(cfgdata, d):
    import os
    import bb
    expected = cfgdata.get("FILESDIR")
    #expected = "${@bb.which(d.getVar('FILESPATH', 1), '.')}"
    unexpanded = d.getVar("FILESDIR", 0)
    if unexpanded is None:
        return False

    expanded = os.path.normpath(d.getVar("FILESDIR", 1))
    filespath = d.getVar("FILESPATH", 1).split(":")
    filespath = [os.path.normpath(f) for f in filespath if os.path.exists(f)]

    return unexpanded != expected and \
           os.path.exists(expanded) and \
           (expanded in filespath or
            expanded == bb.data.expand(expected, d))

def can_remove_others(p, cfgdata, d):
    import bb
    for k in ["S", "PV", "PN", "DESCRIPTION", "LICENSE", "DEPENDS",
              "SECTION", "PACKAGES", "EXTRA_OECONF", "EXTRA_OEMAKE"]:
    #for k in cfgdata:
        unexpanded = d.getVar(k, 0)
        cfgunexpanded = cfgdata.get(k)
        if not cfgunexpanded:
            continue

        try:
            expanded = d.getVar(k, 1)
            cfgexpanded = bb.data.expand(cfgunexpanded, d)
        except bb.fetch.ParameterError:
            continue

        if unexpanded != cfgunexpanded and \
           cfgexpanded == expanded:
           bb.note("%s: recipe_sanity: candidate for removal of %s" % (p, k))
           bb.debug(1, "%s: recipe_sanity:   cfg's '%s' and d's '%s' both expand to %s" %
                       (p, cfgunexpanded, unexpanded, expanded))

python do_recipe_sanity () {
    p = d.getVar("P", 1)
    p = "%s %s %s" % (d.getVar("PN", 1), d.getVar("PV", 1), d.getVar("PR", 1))

    sanitychecks = [
        (can_remove_FILESDIR, "candidate for removal of FILESDIR"),
        (can_remove_FILESPATH, "candidate for removal of FILESPATH"),
        #(can_use_autotools_base, "candidate for use of autotools_base"),
        (incorrect_nonempty_PACKAGES, "native or cross recipe with non-empty PACKAGES"),
    ]
    cfgdata = d.getVar("__recipe_sanity_cfgdata", 0)

    for (func, msg) in sanitychecks:
        if func(cfgdata, d):
            bb.note("%s: recipe_sanity: %s" % (p, msg))

    can_remove_others(p, cfgdata, d)
}
do_recipe_sanity[nostamp] = "1"
#do_recipe_sanity[recrdeptask] = "do_recipe_sanity"
addtask recipe_sanity

do_recipe_sanity_all[nostamp] = "1"
do_recipe_sanity_all[recrdeptask] = "do_recipe_sanity"
do_recipe_sanity_all () {
    :
}
addtask recipe_sanity_all after do_recipe_sanity

python recipe_sanity_eh () {
    from bb.event import getName

    if getName(e) != "ConfigParsed":
        return NotHandled

    d = e.data

    cfgdata = {}
    for k in d.keys():
    #for k in ["S", "PR", "PV", "PN", "DESCRIPTION", "LICENSE", "DEPENDS",
    #          "SECTION"]:
        cfgdata[k] = d.getVar(k, 0)

    d.setVar("__recipe_sanity_cfgdata", cfgdata)
}
addhandler recipe_sanity_eh
