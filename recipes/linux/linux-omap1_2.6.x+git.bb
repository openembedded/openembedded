# The omap1 and omap2  recipes are identical, but we can't merge them till all the linux-omapN_2.6.*.bb recipes have been merged
require linux-omap2_git.bb

DEFAULT_PREFERENCE = "-1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap1-git/${MACHINE}"
COMPATIBLE_MACHINE = "omap5912osk|omap1710h3"

