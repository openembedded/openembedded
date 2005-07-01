PR         = "r0"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = ""

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.orig.tar.gz"

inherit autotools pkgconfig

headers = "a_igeq.h amrnb_socket_node.h audio_socket_node.h  pcm_socket_node.h \
           a_imumdrc.h amrwb_socket_node.h interface_common.h video_socket_node.h \
           aac_socket_node.h audio_pp_socket_node.h mp3_socket_node.h"

do_stage () {

	install -d ${STAGING_INCDIR}/dsp
	for h in ${headers}; do
                install -m 0644 ${S}/include/dsp/$h ${STAGING_INCDIR}/dsp/$h
        done
}