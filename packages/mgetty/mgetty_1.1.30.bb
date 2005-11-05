SECTION = "base"
DESCRIPTION = "The mgetty package contains an intelligent \
getty for allowing logins over a serial line (such as \
through a modem) and receiving incoming faxes."
LICENSE = "GPL"
PR="r3"

# The source can no longer be found at ${DEBIAN_MIRROR}/main/m/mgetty/mgetty_${PV}.orig.tar.gz
# so the nslu2-linux project has mirrored it until someone updates this package to a newer version.
SRC_URI = "http://nslu.sf.net/downloads/mgetty_1.1.30.orig.tar.gz \
           file://debian.patch;patch=1 \
           file://00-g3_Makefile;patch=1 \
           file://01-adjust-path;patch=1 \
           file://02-pending-fix-includes;patch=1 \
           file://03-callback_Makefile;patch=1 \
           file://04-new_fax.pbm;patch=1 \
           file://06-pending-contrib_g3tolj.c;patch=1 \
           file://07-pending-contrib_g3toxwd.c;patch=1 \
           file://09-doc_Makefile;patch=1 \
           file://10-doc_faxrunqd.8in;patch=1 \
           file://12-fax_faxrunqd.in;patch=1 \
           file://13-fax_faxspool.in;patch=1 \
           file://14-frontends_X11_viewfax-2.5_Makefile;patch=1 \
           file://23-samples_new_fax.mime4;patch=1 \
           file://24-voice_include_paths.h;patch=1 \
           file://26-voice_libpvf_usr.c;patch=1 \
           file://36-voice_voice.conf-dist;patch=1 \
           file://37-Makefile;patch=1 \
           file://39-mgetty.cfg.in;patch=1 \
           file://40-locks.c_bug153394;patch=1 \
           file://41-ugly-redo-ring.c_bug128668;patch=1 \
           file://42-voice_libvoice_detect.c;patch=1 \
           file://43-moreinfo-cnd.c_bug112163;patch=1 \
           file://44-pending-faxexpand.h_bug169455;patch=1 \
           file://45-logfile.c;patch=1 \
           file://47-doc_mgetty.texi-in;patch=1 \
           file://50-pending-voice-zoom-2949l-c;patch=1 \
           file://51-pending-faxq-time;patch=1 \
           file://52-pending-metamail;patch=1 \
           file://install.patch;patch=1 \
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
        -DECHO=\""echo -e"\" \
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
