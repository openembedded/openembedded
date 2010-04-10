require pulseaudio.inc

PR = "${INC_PR}.1"

SRC_URI += "\
  file://disable-using-glibc-tls.patch;patch=1 \
  file://libpulsedsp-references-libpulsecore.patch;patch=1 \
  file://pa-drop-caps-returns-void.patch;patch=1 \
#  file://libtool2.patch;patch=1 \
  file://2113.diff;patch=1;pnum=0 \
  file://2114.diff;patch=1;pnum=0 \
  file://libiconv.patch;patch=1 \
"            

do_compile_prepend() {
    cd ${S}
    mkdir -p ${S}/libltdl
    cp ${STAGING_LIBDIR}/libltdl* ${S}/libltdl
}


# problems w/ pulseaudio 0.9.10 atm:
# 1.) needs libltdl >= 1.5.24 (yes, any older version will NOT work at runtime)
# 2.) doesn't build w/ glibc TLS support (hence patched out)
# 3.) fails with hierarchical pthread stuff w/ gst-pulse (hence patched out)


SRC_URI[md5sum] = "9187ac1b302b9ab45f355242f453882e"
SRC_URI[sha256sum] = "1ae8b587759b33ad954e717728fab6df58bd28088d0ac8faf22e90253b774975"
