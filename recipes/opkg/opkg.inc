DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "curl gpgme"
PV = "0.1.6+svnr${SRCREV}"

SRC_URI = "svn://opkg.googlecode.com/svn;module=trunk;proto=http"
SRC_URI_append_shr = " file://make-opkg-handle-config-files-correctly.patch;patch=1;pnum=0"
S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
