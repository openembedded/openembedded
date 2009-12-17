DESCRIPTION = "OpenMAX Integration Layer (IL) is a standard API to access Multimedia Components on mobile platforms. It has been defined by the Khronos group."
LICENSE = "LGPLv2"
DEPENDS = "alsa-lib ffmpeg \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"

SRC_URI = "${SOURCEFORGE_MIRROR}/omxil/${PN}-${PV}.tar.gz"

inherit autotools_stage

AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${libdir}/bellagio/*.so ${libdir}/bellagio/*.la"
FILES_${PN}-dev += "${libdir}/bellagio/*.a"
FILES_${PN}-dbg += "${libdir}/bellagio/.debug"

PARALLEL_MAKE = ""

