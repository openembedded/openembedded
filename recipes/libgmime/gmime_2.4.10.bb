LICENSE = "LGPL"
DESCRIPTION = "Runtime libraries for parsing and creating MIME mail"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "glib-2.0 zlib"

inherit gnome autotools_stage lib_package binconfig

SRC_URI += " \
           file://iconv-detect.h \
	   file://nodolt.patch;patch=1"

EXTRA_OECONF += "--disable-mono"

export ac_cv_have_iconv_detect_h=yes
do_configure_append = "cp ${WORKDIR}/iconv-detect.h ${S}"

# we do not need GNOME 1 gnome-config support
do_install_append () {
	rm -f ${D}${libdir}/gmimeConf.sh
}

SRC_URI[archive.md5sum] = "f0700515d5d715ae6b34289fdca90451"
SRC_URI[archive.sha256sum] = "59c71aa8d0f06c66f863bc0462868237a770ce30d1402af2515235fa41db51ca"
