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


SRC_URI[md5sum] = "42ab7383c4ca4093000ec7062289112b"
SRC_URI[sha256sum] = "dc5d3cf256390d5419ea7dc3fc35761999a1da99fa4b645ac3e92a6a279c38fc"
