DESCRIPTION = "Audio scripts necessary for audio routing on the palmpre machine"
HOMEPAGE = "http://www.palm.com/"
AUTHOR = "Palm Inc."
SECTION = "console/utils"
LICENSE = "Palm"

PR = "r0"
SRC_URI = "http://downloads.freesmartphone.org/palmpre-audio-scripts_${PV}.tar.bz2"

SRC_URI[md5sum] = "3e263163203ce66ae5f3a75776971d73"
SRC_URI[sha256sum] = "044bbd9879f6e46b21c675421501f8920a4cab3ed4623259e2a52abecccd114e"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	install -d ${D}${sysconfdir}/audio/scripts
	
	for script in `ls ${WORKDIR}/*.txt`
	do
		install -m 0644 "${script}" "${D}${sysconfdir}/audio/scripts"
	done
}

