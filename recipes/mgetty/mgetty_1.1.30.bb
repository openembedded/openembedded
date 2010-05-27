SECTION = "base"
DESCRIPTION = "The mgetty package contains an intelligent \
getty for allowing logins over a serial line (such as \
through a modem) and receiving incoming faxes."
LICENSE = "GPL"
PR ="r4"

# The source can no longer be found at ${DEBIAN_MIRROR}/main/m/mgetty/mgetty_${PV}.orig.tar.gz
# so the nslu2-linux project has mirrored it until someone updates this package to a newer version.
SRC_URI = "http://nslu.sf.net/downloads/mgetty_1.1.30.orig.tar.gz \
           file://debian.patch \
           file://00-g3_Makefile;apply=yes \
           file://01-adjust-path;apply=yes \
           file://02-pending-fix-includes;apply=yes \
           file://03-callback_Makefile;apply=yes \
           file://04-new_fax.pbm;apply=yes \
           file://06-pending-contrib_g3tolj.c;apply=yes \
           file://07-pending-contrib_g3toxwd.c;apply=yes \
           file://09-doc_Makefile;apply=yes \
           file://10-doc_faxrunqd.8in;apply=yes \
           file://12-fax_faxrunqd.in;apply=yes \
           file://13-fax_faxspool.in;apply=yes \
           file://14-frontends_X11_viewfax-2.5_Makefile;apply=yes \
           file://23-samples_new_fax.mime4;apply=yes \
           file://24-voice_include_paths.h;apply=yes \
           file://26-voice_libpvf_usr.c;apply=yes \
           file://36-voice_voice.conf-dist;apply=yes \
           file://37-Makefile;apply=yes \
           file://39-mgetty.cfg.in;apply=yes \
           file://40-locks.c_bug153394;apply=yes \
           file://41-ugly-redo-ring.c_bug128668;apply=yes \
           file://42-voice_libvoice_detect.c;apply=yes \
           file://43-moreinfo-cnd.c_bug112163;apply=yes \
           file://44-pending-faxexpand.h_bug169455;apply=yes \
           file://45-logfile.c;apply=yes \
           file://47-doc_mgetty.texi-in;apply=yes \
           file://50-pending-voice-zoom-2949l-c;apply=yes \
           file://51-pending-faxq-time;apply=yes \
           file://52-pending-metamail;apply=yes \
           file://install.patch \
	   file://newslock_ldflags.patch \
	   file://faxqhelper_ldflags.patch \
           file://policy.h \
           file://voice-defs.h"

CFLAGS_prepend = "-DAUTO_PPP -DFIDO "

# This is necessary because of the way the mgetty Makefile works,
# it effectively recursively makes . - without passing MAKE the -e
# flag.  Oops.
export MAKE = "make -e"

do_compile () {
        cp ${WORKDIR}/policy.h ${WORKDIR}/voice-defs.h .
	${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} \
	-I.. -DBINDIR=\"${bindir}\" -DSBINDIR=\"${sbindir}\" \
        -DLIBDIR=\"${libdir}/mgetty-fax\" \
        -DCONFDIR=\"${sysconfdir}/mgetty\" \
        -DFAX_SPOOL=\"/var/spool/fax\" \
        -DFAX_SPOOL_IN=\"/var/spool/fax/incoming\" \
        -DFAX_SPOOL_OUT=\"/var/spool/fax/outgoing\" \
        -DFAX_OUT_USER=\"uucp\" \
        -DVARRUNDIR=\"/var/run\" \
        -DAWK=\"awk\" \
        -DPERL=\""${bindir}/perl -w"\" -DTKPERL=\"${bindir}/tkperl\" \
        -DECHO=\""printf"\" \
        -DSHELL=\"/bin/bash\" \
	-o mksed mksed.c
	./mksed >sedscript
	chmod u+x sedscript
	oe_runmake
	oe_runmake vgetty
#        cd doc; $(MAKE) manpages mgetty.info $(GCC)
#        cd contrib; $(MAKE) g3toxwd g3tolj
#        cd $(VFDIR); $(MAKE)
}

do_install () {
	oe_runmake install DESTDIR="${D}" prefix="${D}${prefix}"
}

CONFFILES_${PN} = "${sysconfdir}/mgetty/mgetty.config \
	${sysconfdir}/mgetty/login.config ${sysconfdir}/mgetty/sendfax.config"

FILES_${PN} += "${libdir}/mgetty-fax"

FILES_${PN}-dbg += "${libdir}/mgetty-fax/.debug"

SRC_URI[md5sum] = "ff7872dbef3332dd8f550da78d387f2e"
SRC_URI[sha256sum] = "008f0bea1fe7fd0f6484536442e660e533bad209ad7a57af3ee6f0a0300fd671"
