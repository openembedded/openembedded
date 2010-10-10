# package_dbg.bbclass: populate -dbg versions for each package in PACKAGES
#
# Copyright (c) 2009 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)


inherit package


PACKAGE_DBG_DESC = "Debugging files for %s"
PACKAGE_DBG_EXCLUDE = "${PN}-locale* ${PN}-doc ${PN}-dev *-dbg"


def add_dbg_packages(d):
    from fnmatch import fnmatch

    packages = d.getVar("PACKAGES", True).split()
    excludes = d.getVar("PACKAGE_DBG_EXCLUDE", True).split()

    for pkg in tuple(packages):
        if any(fnmatch(pkg, excluded) for excluded in excludes):
            continue

        dbgpkg = "%s-dbg" % pkg
        if not dbgpkg in packages:
            packages.insert(0, dbgpkg)

    d.setVar("PACKAGES", " ".join(packages))


# Add the -dbg packages to PACKAGES
python () {
    from bb.data import inherits_class as inherits

    # Task handles its own -dbg versions of its packages at the moment
    if not inherits("task", d):
        dynpkgs = d.getVar("PACKAGES_DYNAMIC", True).split()
        dynpkgs += ["%s-dbg" % dyn for dyn in dynpkgs]
        d.setVar("PACKAGES_DYNAMIC", " ".join(dynpkgs))

        add_dbg_packages(d)
}

python populate_packages_prepend () {
	from bb.data import inherits_class as inherits

	if not inherits("task", d):
		bb.build.exec_func("package_do_dbg", d)
}

# Populate the -dbg subpackage metadata
python package_do_dbg() {
    """ Populate the -dbg subpackage metadata. """

    import oe.package
    from os.path import join, basename, dirname

    def setVar(key, val):
        if d.getVar(key, val) is None:
            d.setVar(key, val)

    add_dbg_packages(d)
    packages = d.getVar("PACKAGES", True).split()
    desc = d.getVar("PACKAGE_DBG_DESC", True)

    done = []
    for pkgname in tuple(packages):
        files = tuple(oe.package.files(pkgname, d))
        dbg = [join(dirname(file), ".debug", basename(file))
               for file in files
               if not file in done]
        done.extend(files)

        if dbg:
            setVar("FILES_%s-dbg" % pkgname, " ".join(dbg))
            setVar("DESCRIPTION_%s-dbg" % pkgname, desc % pkgname)
            setVar("RDEPENDS_%s-dbg" % pkgname, pkgname)
        else:
            try:
                packages.remove("%s-dbg" % pkgname)
            except ValueError:
                pass
    d.setVar("PACKAGES", " ".join(packages))
}
