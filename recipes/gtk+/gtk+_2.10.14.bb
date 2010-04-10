require gtk-2.10.inc

PR = "r9"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
           file://no-xwc.patch;patch=1 \
           file://automake-lossage.patch;patch=1 \
           file://disable-tooltips.patch;patch=1 \
           file://gtklabel-resize-patch;patch=1 \
           file://menu-deactivate.patch;patch=1 \
           file://xsettings.patch;patch=1 \
           file://scroll-timings.patch;patch=1 \
           file://small-gtkfilesel.patch;patch=1 \
           file://small-gtkfilechooser.patch;patch=1 \
#           file://migration.patch;patch=1;pnum=0 \
           file://run-iconcache.patch;patch=1 \
           file://hardcoded_libtool.patch;patch=1 \
           file://no-demos.patch;patch=1 \
           file://single-click.patch;patch=1 \
           file://spinbutton.patch;patch=1 \
           file://gtk+-handhelds.patch;patch=1 \
           file://filesel-fix-segfault.patch;patch=1 \
           file://combo-arrow-size.patch;patch=1;pnum=0 \
           file://range-no-redraw.patch;patch=1;pnum=0 \
           file://scrolled-placement.patch;patch=1;pnum=0 \
           file://treeview-checkbox-size.patch;patch=1;pnum=0 \
           file://cell-renderer-edit-focus.patch;patch=1;pnum=0 \
           "

# check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require gtk-fpu.inc
EXTRA_OECONF += "${@get_gtk_fpu_setting(bb, d)}"


SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"
