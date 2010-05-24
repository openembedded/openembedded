require gtk-2.10.inc

PR = "r9"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
           file://no-xwc.patch;apply=yes \
           file://automake-lossage.patch;apply=yes \
           file://disable-tooltips.patch;apply=yes \
           file://gtklabel-resize-patch;apply=yes \
           file://menu-deactivate.patch;apply=yes \
           file://xsettings.patch;apply=yes \
           file://scroll-timings.patch;apply=yes \
           file://small-gtkfilesel.patch;apply=yes \
           file://small-gtkfilechooser.patch;apply=yes \
#           file://migration.patch;apply=yes;striplevel=0 \
           file://run-iconcache.patch;apply=yes \
           file://hardcoded_libtool.patch;apply=yes \
           file://no-demos.patch;apply=yes \
           file://single-click.patch;apply=yes \
           file://spinbutton.patch;apply=yes \
           file://gtk+-handhelds.patch;apply=yes \
           file://filesel-fix-segfault.patch;apply=yes \
           file://combo-arrow-size.patch;apply=yes;striplevel=0 \
           file://range-no-redraw.patch;apply=yes;striplevel=0 \
           file://scrolled-placement.patch;apply=yes;striplevel=0 \
           file://treeview-checkbox-size.patch;apply=yes;striplevel=0 \
           file://cell-renderer-edit-focus.patch;apply=yes;striplevel=0 \
           "

# check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require gtk-fpu.inc
EXTRA_OECONF += "${@get_gtk_fpu_setting(bb, d)}"


SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"
