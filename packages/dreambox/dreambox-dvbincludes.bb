DESCRIPTION = "This package provides dbox2/dreambox \
compatible header files for the API to the drivers."

MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRC_URI = "http://sources.dreamboxupdate.com/snapshots/include2.tar.gz"
S = "${WORKDIR}/include"

INPUT_FILES = "input_fake.h ci/ci.h  dbox/avia_gt_pig.h dbox/avs_core.h \
	dbox/event.h dbox/fp.h dbox/info.h dbox/lcd.h dbox/saa7126_core.h \
	dbox/lcd-ks0713.h dbox/fb.h \
	dreambox/dreaminfo.h \
	ost/audio.h ost/ca.h ost/demux.h ost/descrambler.h ost/dmx.h \
	ost/dvb.h ost/dvb_frontend.h  ost/frontend.h ost/net.h ost/sec.h \
	ost/video.h \
	tuxbox/hardware_dbox2.h tuxbox/hardware_dreambox.h tuxbox/hardware_pci.h \
	tuxbox/info.h tuxbox/info_dbox2.h tuxbox/kernel.h"

PV="1"

do_install() {
	install -d ${STAGING_INCDIR}/ci
	install -d ${STAGING_INCDIR}/dbox
	install -d ${STAGING_INCDIR}/dreambox
	install -d ${STAGING_INCDIR}/ost
	install -d ${STAGING_INCDIR}/tuxbox
	for f in ${INPUT_FILES}; do
		install -m 0644 ${S}/$f ${STAGING_INCDIR}/$f
	done;
}
