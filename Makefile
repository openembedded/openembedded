# Makefile for the NSLU2 Linux development system
# Licensed under the GPL v2 or later

# Change these if you are unfortunate enough to have a split net personality.
SVN_USER ?= ${USER}
CVS_USER ?= ${USER}

.PHONY: all
all: update build

.PHONY: build
build: build-unslung build-openslug build-optware

.PHONY: setup
setup: setup-master setup-bitbake setup-openembedded setup-optware

.PHONY: setup-developer
setup-developer: setup-master setup-bitbake setup-openembedded setup-optware-developer

.PHONY: update
update: update-master update-bitbake update-openembedded update-optware

.PHONY: clobber
clobber: clobber-optware clobber-openembedded clobber-bitbake

.PHONY: unslung build-unslung
unslung build-unslung: unslung/Makefile bitbake/bin/bitbake openembedded/conf/machine/nslu2.conf
	( cd unslung ; make )

.PHONY: openslug build-openslug
openslug build-openslug: openslug/Makefile bitbake/bin/bitbake openembedded/conf/machine/nslu2.conf
	( cd openslug ; make )

.PHONY: optware build-optware
optware build-optware: optware/Makefile
	( cd optware ; unset LD_LIBRARY_PATH; make )

.PHONY: setup-monotone
setup-monotone monotone/nslu2-linux.db:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && monotone -d monotone/nslu2-linux.db db init )
	( monotone -d monotone/nslu2-linux.db pull monotone.vanille.de org.openembedded.* )
	( monotone -d monotone/nslu2-linux.db unset database default-server )
	( monotone -d monotone/nslu2-linux.db unset database default-include-pattern )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org.openembedded.* org.nslu2-linux.* )
	# Above may be supplemented  by following someday
	# wget http://www.nslu2-linux.org/nslu2-linux.initial.db -O monotone/nslu2-linux.db

downloads:
	[ -e downloads ] || mkdir -p downloads

unslung/Makefile openslug/Makefile MT/revision:
	${MAKE} downloads
	[ -e monotone/nslu2-linux.db ] || ( ${MAKE} monotone/nslu2-linux.db )
	[ -e MT/revision ] || ( monotone -d monotone/nslu2-linux.db co -b org.nslu2-linux.dev . )

.PHONY: setup-master
setup-master: setup-monotone unslung/Makefile openslug/Makefile
	[ -e unslung/downloads ]  || ( cd unslung  ; ln -s ../downloads . )
	[ -e openslug/downloads ] || ( cd openslug ; ln -s ../downloads . )

.PHONY: setup-bitbake
setup-bitbake bitbake/bin/bitbake:
	${MAKE} MT/revision
	[ -e bitbake/bin/bitbake ] || monotone co -b org.nslu2-linux.bitbake bitbake

.PHONY: setup-openembedded
setup-openembedded openembedded/conf/machine/nslu2.conf:
	${MAKE} MT/revision
	[ -e openembedded/conf/machine/nslu2.conf ] || monotone co -b org.openembedded.nslu2-linux openembedded

.PHONY: setup-optware
setup-optware optware/Makefile:
	${MAKE} downloads
	[ -e optware/Makefile ] || ( cvs -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )
	[ -e optware/downloads ] || ( cd optware ; ln -s ../downloads . )

.PHONY: setup-optware-developer
setup-optware-developer:
	${MAKE} downloads
	[ -e optware ] && ( mv optware optware-user )
	cvs -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co -d optware unslung
	[ -e optware/downloads ] || ( cd optware ; ln -s ../downloads . )

.PHONY: setup-slugimage-developer
setup-slugimage-developer:
	cvs -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co slugimage

.PHONY: setup-upslug-developer
setup-upslug-developer:
	cvs -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co upslug

.PHONY: setup-sluggo-developer
setup-sluggo-developer:
	cvs -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co sluggo

.PHONY: setup-apex
setup-apex apex/Makefile:
	cvs -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co apex

.PHONY: setup-apex-developer
setup-apex-developer:
	cvs -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co apex

.PHONY: setup-host-debian
setup-host-debian:
	sudo apt-get install \
		autoconf automake automake1.9 \
		bison \
		ccache \
		cvs \
		docbook \
		flex \
		g++ gawk gcj gettext \
		libc6-dev libglib2.0-dev libtool \
		m4 make \
		patch pkg-config \
		python python-dev python-psyco python2.4 python2.4-dev \
		sed \
		texinfo \
		unzip

.PHONY: update-master
update-master: MT/revision
	monotone pull
	if [ `monotone automate heads org.nslu2-linux.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.dev ; \
	fi
	monotone update
	if [ `monotone automate heads org.nslu2-linux.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.dev ; \
	fi

.PHONY: update-bitbake
update-bitbake: bitbake/bin/bitbake
	monotone pull
	if [ `monotone automate heads org.nslu2-linux.bitbake | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.bitbake ; \
	fi
	( cd bitbake ; monotone update )
	if [ `monotone automate heads org.nslu2-linux.bitbake | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.bitbake ; \
	fi

.PHONY: update-openembedded
update-openembedded: openembedded/conf/machine/nslu2.conf
	monotone pull
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi
	( cd openembedded ; monotone update )
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: update-optware
update-optware: optware/Makefile
	( cd optware ; cvs update -d -P )

.PHONY: clobber-bitbake
clobber-bitbake:
	rm -rf bitbake

.PHONY: clobber-openembedded
clobber-openembedded:
	rm -rf openembedded

.PHONY: clobber-optware
clobber-optware:
	rm -rf optware

# Targets for use by those with write access to the repositories

.PHONY: push
push: push-master push-openembedded

.PHONY: push-master
push-master: update-master
	monotone push

.PHONY: push-openembedded
push-openembedded: update-openembedded
	( cd openembedded ; monotone push )

# Targets for use by core team members only

.PHONY: publish-master
publish-master: push-master
	scp Makefile www.nslu2-linux.org:/home/nslu/public_html/Makefile

.PHONY: upload-openslug-cross
upload-openslug-cross: openslug/Makefile
	rsync --size-only --delete -av --exclude="morgue" openslug/tmp/deploy/ipk/ unslung@nslu.sf.net:nslu/feeds/openslug/unstable/

.PHONY: import-openembedded
import-openembedded: openembedded/conf/machine/nslu2.conf
	monotone pull monotone.vanille.de org.openembedded.*
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi

.PHONY: propagate-from-oe
propagate-from-oe: 
	monotone propagate org.openembedded.dev org.openembedded.nslu2-linux
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: propagate-to-oe
propagate-to-oe: 
	monotone propagate org.openembedded.nslu2-linux org.openembedded.dev
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi

.PHONY: export-openembedded
export-openembedded: openembedded/conf/machine/nslu2.conf
	monotone push monotone.vanille.de org.openembedded.*

.PHONY: publish-openembedded
publish-openembedded: import-openembedded propagate-from-oe update-openembedded \
		      propagate-to-oe push-openembedded export-openembedded

# End of Makefile
