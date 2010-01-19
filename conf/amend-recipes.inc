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

    # Adding all amend.incs that can exist to the __depends, to ensure that
    # creating one of them invalidates the bitbake cache.  Note that it
    # requires a fix in bitbake.  Without the bitbake fix, the cache will be
    # completely invalidated on every bitbake execution.
    depends = d.getVar("__depends", 0) or []
    d.setVar("__depends", depends + [(file, 0) for file in amendfiles if not os.path.exists(file)])

    existing = (file for file in amendfiles if os.path.exists(file))
    try:
        bb.parse.handle(existing.next(), d, 1)
    except StopIteration:
        pass
}
