require gnutls.inc

PR = "${INC_PR}.0"

LICENSE_${PN}-extra = "GPLv3"

EXTRA_OECONF += " --without-libgcrypt-prefix "

SRC_URI += "file://gettextize-with-gettext-0.18.patch \
            file://gnutls-openssl.patch \
            file://gnutls-replace-siginterrupt.patch \
           "

do_configure_prepend() {

 MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"

 for i in ${MACROS}; do
   rm -f m4/$i
   rm -f lib/m4/$i
   rm -f libextra/m4/$i
 done

}

SRC_URI[gnutls.md5sum] = "777823f5746ab80cd6f7f7b5fcb2f91b"
SRC_URI[gnutls.sha256sum] = "e82e7a3fc69b02cc06c291a1652789d73e45bc0732e139817838248f814f8724"
