DESCRIPTION = "/etc/image-version image information for tuxbox images"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"
PV = "0"
PR = "r0"
LICENSE = "GPL"

FILES_${PN} = "/etc/image-version"

do_install () {
	IMAGE_VERSION=`echo ${DISTRO_VERSION} | sed  's/\(.\)\.\(.\).\(.\)/\1\2\3/' `
	IMAGE_DATE="$(date +%Y%m%d%H%M)"
	IMAGE_TYPE="0"
	mkdir -p ${D}/etc/
	echo "version=${IMAGE_TYPE}${IMAGE_VERSION}${IMAGE_DATE}" > ${D}/etc/image-version
	echo "comment=${DISTRO_NAME}" >> ${D}/etc/image-version
	echo "target=9"  >> ${D}/etc/image-version
	echo "creator=OpenEmbedded <oe@dreamboxupdate.com>" >> ${D}/etc/image-version
	echo "url=http://www.dreamboxupdate.com/" >> ${D}/etc/image-version
	echo "catalog=http://www.dreamboxupdate.com/" >> ${D}/etc/image-version
}
