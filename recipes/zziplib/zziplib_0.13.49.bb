require zziplib.inc

PR = "r1"

SRC_URI += "\
  file://zip_c.patch;patch=1 \
  file://zziplib-autoconf.patch;patch=1 \
  "

#EXTRA_OECONF = "--srcdir=${S} --enable-builddir=${S}/build"

do_stage() {
  autotools_stage_all
}

SRC_URI[md5sum] = "5f7b88ebb2bcd7e8044328482d079661"
SRC_URI[sha256sum] = "f57c4e33eb2cdd87a6c2f01bfa4794340fbe61ea1a1cfc7dac3b6671e1dd22af"
