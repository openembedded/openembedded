require gnutls.inc

PR = "${INC_PR}.1"

EXTRA_OECONF += " --without-libgcrypt-prefix "

SRC_URI += "file://gettextize-with-gettext-0.18.patch \
            file://gnutls-openssl.patch \
            file://gnutls-replace-siginterrupt.patch \
           "

# This is a workaround to get away with gcc ICE
# as seen here https://bugs.launchpad.net/gcc-linaro/+bug/736439

CFLAGS_arm_append = " -O2"

do_configure_prepend() {

 MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"

 for i in ${MACROS}; do
   rm -f m4/$i
   rm -f lib/m4/$i
   rm -f libextra/m4/$i
 done

}

SRC_URI[gnutls.md5sum] = "4e1517084018a8b1fdc96daabea40528"
SRC_URI[gnutls.sha256sum] = "b8bfe36450fe671e99db5ff1e44e6b65fda8a79cacd9e77d550eff7da3745fc8"
