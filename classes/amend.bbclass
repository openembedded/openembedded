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

    filespath = d.getVar("FILESPATH", 1).split(":")
    amendfiles = [os.path.join(fpath, "amend.inc")
                  for fpath in filespath]

    newdata = []
    seen = set()
    for file in amendfiles:
        if file in seen:
            continue
        seen.add(file)

        if os.path.exists(file):
            bb.parse.handle(file, d, 1)
        else:
            # Manually add amend.inc files that don't exist to the __depends, to
            # ensure that creating them invalidates the bitbake cache for that recipe.
            newdata.append((file, 0))

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
}
