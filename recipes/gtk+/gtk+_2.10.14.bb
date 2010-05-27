require gtk-2.10.inc

PR = "r9"

SRC_URI = "ftp://ftp.gtk.org/pub/gtk/v2.10/gtk+-${PV}.tar.bz2 \
           file://no-xwc.patch \
           file://automake-lossage.patch \
           file://disable-tooltips.patch \
           file://gtklabel-resize-patch;apply=yes \
           file://menu-deactivate.patch \
           file://xsettings.patch \
           file://scroll-timings.patch \
           file://small-gtkfilesel.patch \
           file://small-gtkfilechooser.patch \
#           file://migration.patch;striplevel=0 \
           file://run-iconcache.patch \
           file://hardcoded_libtool.patch \
           file://no-demos.patch \
           file://single-click.patch \
           file://spinbutton.patch \
           file://gtk+-handhelds.patch \
           file://filesel-fix-segfault.patch \
           file://combo-arrow-size.patch;striplevel=0 \
           file://range-no-redraw.patch;striplevel=0 \
           file://scrolled-placement.patch;striplevel=0 \
           file://treeview-checkbox-size.patch;striplevel=0 \
           file://cell-renderer-edit-focus.patch;striplevel=0 \
           "

# check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require gtk-fpu.inc
EXTRA_OECONF += "${@get_gtk_fpu_setting(bb, d)}"


SRC_URI[md5sum] = "018d7dd0fa7de01cfdb77c7c55e7ba26"
SRC_URI[sha256sum] = "d02344239d048390ba02fcfd7de4f9efc0dfb51e7b06dfa46a6314d666ea4de2"
