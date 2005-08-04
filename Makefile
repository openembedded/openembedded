# Makefile for the NSLU2 Linux development system
# Licensed under the GPL v2 or later

# Change these if you are unfortunate enough to have a split net personality.
SVN_USER ?= ${USER}
CVS_USER ?= ${USER}
SVN_SSH ?= "-l ${SVN_USER}"

HOST_MACHINE:=$(shell uname -m | sed \
	-e 's/i[3-9]86/i386/' \
	-e 's/armv5teb/armeb/' \
	-e 's/armv5b/armeb/' \
	)

.PHONY: all
all: update build

.PHONY: build
build: build-unslung build-openslug build-ucslugc build-optware

.PHONY: setup
setup: setup-master setup-bitbake setup-openembedded setup-unslung setup-openslug setup-ucslugc setup-optware

.PHONY: setup-developer
setup-developer: setup-master setup-bitbake setup-openembedded setup-optware-developer

.PHONY: update
update: update-master update-bitbake update-openembedded update-optware

.PHONY: status
status: status-master status-bitbake status-openembedded status-optware

.PHONY: clobber
clobber: clobber-master clobber-bitbake clobber-openembedded \
	 clobber-unslung clobber-openslug clobber-ucslugc clobber-optware clobber-releases

.PHONY: unslung build-unslung
unslung build-unslung: unslung/.configured bitbake/.configured openembedded/.configured
	( cd unslung ; ${MAKE} )

.PHONY: openslug build-openslug
openslug build-openslug: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} )

.PHONY: ucslugc build-ucslugc
ucslugc build-ucslugc: ucslugc/.configured bitbake/.configured openembedded/.configured
	( cd ucslugc ; ${MAKE} )

.PHONY: optware build-optware
optware build-optware: build-optware-nslu2 build-optware-wl500g

.PHONY: optware-nslu2 build-optware-nslu2
optware-nslu2 build-optware-nslu2: optware/nslu2/.configured
	( cd optware/nslu2 ; ${MAKE} autoclean ; ${MAKE} )

.PHONY: optware-wl500g build-optware-wl500g
optware-wl500g build-optware-wl500g: optware/wl500g/.configured
	( cd optware/wl500g ; ${MAKE} autoclean ; ${MAKE} )

.PHONY: openslug-2.3-beta build-openslug-2.3-beta
openslug-2.3-beta build-openslug-2.3-beta: releases/OpenSlug-2.3-beta/.configured
	( cd releases/OpenSlug-2.3-beta ; ${MAKE} openslug-firmware )

.PHONY: setup-master
setup-master MT/.configured:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && \
	wget http://sources.nslu2-linux.org/monotone/nslu2-linux.db.gz -O monotone/nslu2-linux.db.gz && \
	gunzip monotone/nslu2-linux.db.gz )
	- ( monotone -d monotone/nslu2-linux.db unset database default-server )
	- ( monotone -d monotone/nslu2-linux.db unset database default-include-pattern )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org.openembedded.* org.nslu2-linux.* )
	[ -e MT/revision ] || ( monotone -d monotone/nslu2-linux.db co -b org.nslu2-linux.dev . )
	touch MT/.configured

.PHONY: setup-bitbake
setup-bitbake bitbake/.configured: MT/.configured
	[ -e bitbake/bin/bitbake ] || monotone co -b org.nslu2-linux.bitbake bitbake
	touch bitbake/.configured

.PHONY: setup-openembedded
setup-openembedded openembedded/.configured: MT/.configured
	[ -e openembedded/conf/machine/nslu2.conf ] || monotone co -b org.openembedded.nslu2-linux openembedded
	touch openembedded/.configured

.PHONY: setup-unslung setup-openslug setup-ucslugc
setup-unslung setup-openslug setup-ucslugc: setup-%: MT/.configured
	rm -rf $*/.configured
	${MAKE} $*/.configured

%/.configured: MT/.configured
	[ -d $* ] || ( mkdir -p $* )
	[ -e downloads ] || ( mkdir -p downloads )
	[ -L $*/Makefile -o ! -e $*/Makefile ] || ( cd $* ; mv Makefile Makefile.delete-me)
	[ -e $*/Makefile ] || ( cd $* ; ln -s ../common/openembedded.mk Makefile )
	[ -L $*/setup-env -o ! -e $*/setup-env ] || ( cd $* ; mv setup-env setup-env.delete-me )
	[ -e $*/setup-env ] || ( cd $* ; ln -s ../common/setup-env . )
	[ -e $*/downloads ] || ( cd $* ; ln -s ../downloads . )
	[ -e $*/bitbake ] || ( cd $* ; ln -s ../bitbake . )
	[ -e $*/openembedded ] || ( cd $* ; ln -s ../openembedded . )
	[ -d $*/conf ] || ( mkdir -p $*/conf )
	[ ! -f $*/conf/local.conf -o -e $*/conf/auto.conf ] || ( cd $*/conf ; mv local.conf local.conf.delete-me )
	[ -e $*/conf/local.conf.sample ] || ( cd $*/conf ; ln -s ../../common/conf/local.conf.sample . )
	[ -e $*/conf/site.conf ] || ( cd $*/conf ; ln -s ../../common/conf/site.conf . )
	[ ! -f $*/conf/auto.conf ] || ( cd $*/conf ; rm -f auto.conf )
	[ -e $*/conf/auto.conf ] || ( \
		if [ "${HOST_MACHINE}" = "armeb" ] ; then \
			echo "DISTRO=\"$*-native\"" > $*/conf/auto.conf ; \
		else \
			echo "DISTRO=\"$*\"" > $*/conf/auto.conf ; \
		fi ; \
		echo "MACHINE=\"nslu2\"" >> $*/conf/auto.conf \
	)
	rm -rf $*/tmp/cache
	touch $*/.configured

.PHONY: setup-optware
setup-optware optware/.configured: MT/.configured
	[ -e downloads ]        || ( mkdir -p downloads )
	[ -e optware/Makefile ] || ( cvs -q -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )
	touch optware/.configured

optware/nslu2/.configured: optware/.configured
	[ -e optware/nslu2/Makefile ] || ( \
		mkdir -p optware/nslu2 ; \
		echo "OPTWARE_TARGET=nslu2" > optware/nslu2/Makefile ; \
	 	echo "include ../Makefile" >> optware/nslu2/Makefile ; \
		ln -s ../../downloads optware/nslu2/downloads ; \
		ln -s ../make optware/nslu2/make ; \
		ln -s ../scripts optware/nslu2/scripts ; \
		ln -s ../sources optware/nslu2/sources ; \
	)
	touch optware/nslu2/.configured

optware/wl500g/.configured: optware/.configured
	[ -e optware/wl500g/Makefile ] || ( \
		mkdir -p optware/wl500g ; \
		echo "OPTWARE_TARGET=wl500g" > optware/wl500g/Makefile ; \
	 	echo "include ../Makefile" >> optware/wl500g/Makefile ; \
		ln -s ../../downloads optware/wl500g/downloads ; \
		ln -s ../make optware/wl500g/make ; \
		ln -s ../scripts optware/wl500g/scripts ; \
		ln -s ../sources optware/wl500g/sources ; \
	)
	touch optware/wl500g/.configured

.PHONY: setup-optware-developer
setup-optware-developer:
	[ ! -e optware ] || ( mv optware optware-user )
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co -d optware unslung
	${MAKE} setup-optware

.PHONY: setup-slugimage-developer
setup-slugimage-developer:
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co slugimage

.PHONY: setup-upslug-developer
setup-upslug-developer:
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co upslug

.PHONY: setup-sluggo-developer
setup-sluggo-developer:
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co sluggo

.PHONY: setup-apex
setup-apex apex/Makefile:
	cvs -q -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co apex

.PHONY: setup-apex-developer
setup-apex-developer:
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co apex

.PHONY: setup-openslug-2.3-beta
setup-openslug-2.3-beta releases/OpenSlug-2.3-beta/.configured:
	[ -e releases/OpenSlug-2.3-beta ] || ( \
		mkdir -p releases ; \
		svn checkout svn://svn.berlios.de/openslug/releases/OpenSlug-2.3-beta \
			releases/OpenSlug-2.3-beta \
	)
	( cd releases/OpenSlug-2.3-beta ; ${MAKE} conf/local.conf setup-env )
	[ -e downloads ] || ( mkdir -p downloads )
	[ -e releases/OpenSlug-2.3-beta/downloads ] || ln -s ../../downloads releases/OpenSlug-2.3-beta/
	touch releases/OpenSlug-2.3-beta/.configured

.PHONY: setup-openslug-2.3-beta-developer
setup-openslug-2.3-beta-developer:
	[ -e releases/OpenSlug-2.3-beta ] || ( \
		mkdir -p releases ; \
		svn checkout svn+ssh://svn.berlios.de/svnroot/repos/openslug/releases/OpenSlug-2.3-beta \
			releases/OpenSlug-2.3-beta \
	)
	${MAKE} setup-openslug-2.3-beta

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
update-master: MT/.configured
	monotone pull
	if [ `monotone automate heads org.nslu2-linux.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.dev ; \
	fi
	monotone update
	if [ `monotone automate heads org.nslu2-linux.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.dev ; \
	fi

.PHONY: update-bitbake
update-bitbake: bitbake/.configured
	monotone pull
	if [ `monotone automate heads org.nslu2-linux.bitbake | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.bitbake ; \
	fi
	( cd bitbake ; monotone update )
	if [ `monotone automate heads org.nslu2-linux.bitbake | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.bitbake ; \
	fi

.PHONY: update-openembedded
update-openembedded: openembedded/.configured
	monotone pull
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi
	( cd openembedded ; monotone update )
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: update-optware
update-optware: optware/.configured
	( cd optware ; cvs -q update -d -P )

.PHONY: update-openslug-2.3-beta
update-openslug-2.3-beta: releases/OpenSlug-2.3-beta/.configured
	( cd releases/OpenSlug-2.3-beta ; svn up )

.PHONY: status-master
status-master: MT/.configured
	monotone status --brief

.PHONY: status-bitbake
status-bitbake: bitbake/.configured
	( cd bitbake ; monotone status --brief )

.PHONY: status-openembedded
status-openembedded: openembedded/.configured
	( cd openembedded ; monotone status --brief )

.PHONY: status-optware
status-optware: optware/.configured
	( cd optware ; cvs -q update -d -P )

.PHONY: status-openslug-2.3-beta
status-openslug-2.3-beta: 
	( cd releases/OpenSlug-2.3-beta ; svn status )

.PHONY: clobber-master
clobber-master:
	rm -rf MT common downloads openslug scripts ucslugc unslung

.PHONY: clobber-bitbake
clobber-bitbake:
	rm -rf bitbake

.PHONY: clobber-openembedded
clobber-openembedded:
	rm -rf openembedded

.PHONY: clobber-unslung
clobber-unslung:
	rm -rf unslung

.PHONY: clobber-openslug
clobber-openslug:
	rm -rf openslug

.PHONY: clobber-ucslugc
clobber-ucslugc:
	rm -rf ucslugc

.PHONY: clobber-optware
clobber-optware:
	rm -rf optware

.PHONY: clobber-releases
clobber-releases:
	rm -rf releases

# Targets for use by those with write access to the repositories

.PHONY: push
push: push-master push-bitbake push-openembedded

.PHONY: push-master
push-master: update-master
	monotone push
	scp Makefile slug@nugabe.nslu2-linux.org:htdocs/www/Makefile

.PHONY: push-bitbake
push-bitbake: update-bitbake
	( cd bitbake ; monotone push )

.PHONY: push-openembedded
push-openembedded: update-openembedded
	( cd openembedded ; monotone push )

# Targets for use by core team members only

.PHONY: autobuild
autobuild:
	( set errors=0 ; \
	${MAKE} update                                           || $$errors++; \
	${MAKE} build-openslug       upload-openslug-cross       || $$errors++ ; \
	${MAKE} build-ucslugc        upload-ucslugc-cross        || $$errors++; \
	${MAKE} build-unslung        upload-unslung-modules      || $$errors++ ; \
	${MAKE} build-optware-nslu2  upload-optware-nslu2-cross  || $$errors++; \
	${MAKE} build-optware-wl500g upload-optware-wl500g-cross || $$errors++; \
	${MAKE}                      upload-sources              || $$errors++ ; \
	if [ "$$errors" != "0" ] ; then \
		echo "*** Errors during autobuild: $$errors ***" ; \
	fi \
	)

.PHONY: upload
upload: upload-openslug-cross upload-ucslugc-cross upload-unslung-modules upload-optware-nslu2-cross upload-optware-wl500g-cross upload-sources

.PHONY: upload-openslug-cross
upload-openslug-cross: openslug/.configured
	rm -rf openslug/tmp/deploy/ipk/morgue
	rsync -vlrt --exclude='Packages*' openslug/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk openslug/cross/unstable
	rsync -vl openslug/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	rsync -vlrt --delete openslug/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean openslug/cross/unstable

.PHONY: upload-openslug-2.3-beta-cross
upload-openslug-2.3-beta-cross: releases/OpenSlug-2.3-beta/.configured
	rm -rf releases/OpenSlug-2.3-beta/tmp/deploy/ipk/morgue
	rsync -vlrt --exclude='Packages*' releases/OpenSlug-2.3-beta/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/2.3-beta/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk openslug/cross/2.3-beta
	rsync -vl releases/OpenSlug-2.3-beta/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/2.3-beta/
	rsync -vlrt --delete releases/OpenSlug-2.3-beta/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/2.3-beta/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean openslug/cross/2.3-beta

.PHONY: upload-ucslugc-cross
upload-ucslugc-cross: ucslugc/.configured
	rm -rf ucslugc/tmp/deploy/ipk/morgue
	rsync -vlrt --exclude='Packages*' ucslugc/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/ucslugc/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk ucslugc/cross/unstable
	rsync -vl ucslugc/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/ucslugc/cross/unstable/
	rsync -vlrt --delete ucslugc/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/ucslugc/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean ucslugc/cross/unstable

.PHONY: upload-unslung-modules
upload-unslung-modules: unslung/.configured
	rm -rf unslung/tmp/deploy/ipk/morgue
	scripts/package-strip.pl kernel-module-\* unslung/tmp/deploy/ipk/Packages unslung/tmp/deploy/ipk/Packages.new
	mv unslung/tmp/deploy/ipk/Packages.new unslung/tmp/deploy/ipk/Packages
	rm -f unslung/tmp/deploy/ipk/Packages.gz
	gzip -c unslung/tmp/deploy/ipk/Packages > unslung/tmp/deploy/ipk/Packages.gz
	rsync -vlt unslung/tmp/deploy/ipk/kernel-module-* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk unslung/oe
	rsync -vl unslung/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean unslung/oe
#	rsync -vlt --delete unslung/tmp/deploy/ipk/kernel-module-* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/

.PHONY: upload-optware-nslu2-cross
upload-optware-nslu2-cross: optware/nslu2/.configured
	rsync -vlrt --exclude='Packages*' optware/nslu2/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk unslung/cross
	rsync -vl optware/nslu2/packages/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	rsync -vlrt --delete optware/nslu2/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean unslung/cross

.PHONY: upload-optware-wl500g-cross
upload-optware-wl500g-cross: optware/wl500g/.configured
	rsync -vlrt --exclude='Packages*' optware/wl500g/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk unslung/wl500g
	rsync -vl optware/wl500g/packages/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	rsync -vlrt --delete optware/wl500g/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean unslung/wl500g

.PHONY: upload-sources
upload-sources:
	rsync -vlrt --exclude='ixp400*' downloads/ nslu2@sources.nslu2-linux.org:ipkg/sources/

.PHONY: import-bitbake
import-bitbake: bitbake/.configured
	mv bitbake bitbake.old
	svn co svn://svn.berlios.de/bitbake/trunk/bitbake
	cp -rp bitbake.old/MT bitbake.old/.mt-attrs bitbake
	rm -rf bitbake.old
	( cd bitbake ; rm -rf .svn ; monotone status )

.PHONY: import-openembedded
import-openembedded: openembedded/.configured
	monotone pull monotone.vanille.de org.openembedded.*
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi
	monotone propagate org.openembedded.dev org.openembedded.nslu2-linux
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: export-openembedded
export-openembedded: openembedded/.configured
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	monotone propagate org.openembedded.nslu2-linux org.openembedded.dev
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	monotone push monotone.vanille.de org.openembedded.*

.PHONY: publish-openembedded
publish-openembedded: import-openembedded update-openembedded push-openembedded export-openembedded

# End of Makefile
