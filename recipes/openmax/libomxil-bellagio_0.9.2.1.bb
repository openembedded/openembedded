DESCRIPTION = "OpenMAX Integration Layer (IL) is a standard API to access Multimedia Components on mobile platforms. It has been defined by the Khronos group."
LICENSE = "LGPLv2"
DEPENDS = "alsa-lib ffmpeg \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad', d)}"

SRC_URI = "${SOURCEFORGE_MIRROR}/omxil/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "323049db668ab260870fd7ecd2ec4156"
SRC_URI[sha256sum] = "75cf8d3b5cac2764420ae2cc7846b9bb12a47d2ca04c96e5821309b0124ddc72"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${libdir}/bellagio/*.so ${libdir}/bellagio/*.la"
FILES_${PN}-dev += "${libdir}/bellagio/*.a"
FILES_${PN}-dbg += "${libdir}/bellagio/.debug"

PARALLEL_MAKE = ""

