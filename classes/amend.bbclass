# Allows tweaks to be amended to a recipe via a .inc in its FILESPATH
#
# Simply drop amend.inc into an appropriate place in a recipe's FILESPATH and
# it'll be parsed in after the recipe itself is.
#
# Copyright (c) 2009 MontaVista Software, Inc.  All rights reserved.
#
# Released under the MIT license (see LICENSE.MIT for the terms)

python () {
    import bb, os

    seen = set()
    def __amendfiles():
        for base in d.getVar("FILESPATHBASE", True).split(":"):
            for pkg in d.getVar("FILESPATHPKG", True).split(":"):
                path = os.path.join(base, pkg, "amend.inc")
                if path not in seen:
                    seen.add(path)
                    yield path

    newdata = []
    for amend in __amendfiles():
        if os.path.exists(amend):
            bb.parse.handle(amend, d, 1)
        else:
            # Manually add amend.inc files that don't exist to the __depends,
            # to ensure that creating them invalidates the bitbake cache
            newdata.append((amend, 0))

    if not newdata:
        return

    depends = d.getVar("__depends", False)
    bbversion = tuple(int(i) for i in bb.__version__.split("."))
    if bbversion < (1, 11, 0):
        if depends is None:
            depends = []
        depends += newdata
    else:
        if depends is None:
            depends = set()
        depends |= set(newdata)
    d.setVar("__depends", depends)

    set_multimach_arch(d)
}
