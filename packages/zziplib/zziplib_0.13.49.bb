require zziplib.inc

SRC_URI += "\
  file://zip_c.patch;patch=1 \
  file://zziplib-autoconf.patch;patch=1 \
  "

#EXTRA_OECONF = "--srcdir=${S} --enable-builddir=${S}/build"

do_stage() {
  autotools_stage_all
}
