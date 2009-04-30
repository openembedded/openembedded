require osb-nrcore.inc

PV = "0.5.2+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://gtk-webcore.svn.sourceforge.net/svnroot/gtk-webcore/trunk;module=NRCore;proto=https \
           file://gcc4-fno-threadsafe-statics-NRCore.patch;patch=1 \
	   file://build_silence.patch;patch=0;maxdate=20070401 \
	   file://path_fixes.patch;patch=1"

S = "${WORKDIR}/NRCore"

do_stage () {
        oe_libinstall -so libgtk_webcore_nrcore ${STAGING_LIBDIR}
        oe_libinstall -so -C kwiq libgtk_webcore_nrcore_kwiq_gtk ${STAGING_LIBDIR}

        autotools_stage_includes
 
        install -d ${STAGING_INCDIR}/osb/NRCore
        for i in ${S}/kwiq/WebCore*.h ${S}/kwiq/KWIQ*.h; do
                install -m 0644 $i ${STAGING_INCDIR}/osb/NRCore
        done
}
