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
optware build-optware: build-optware-nslu2 build-optware-wl500g

.PHONY: optware-nslu2 build-optware-nslu2
optware-nslu2 build-optware-nslu2: optware/nslu2/Makefile
	( cd optware/nslu2 ; make autoclean ; make )

.PHONY: optware-wl500g build-optware-wl500g
optware-wl500g build-optware-wl500g: optware/wl500g/Makefile
	( cd optware/wl500g ; make autoclean ; make )

.PHONY: setup-monotone
setup-monotone monotone/nslu2-linux.db:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && \
	wget http://ipkg-us-dyoung.nslu2-linux.org/monotone/nslu2-linux.db.gz -O monotone/nslu2-linux.db.gz && \
	gunzip monotone/nslu2-linux.db.gz )
	- ( monotone -d monotone/nslu2-linux.db unset database default-server )
	- ( monotone -d monotone/nslu2-linux.db unset database default-include-pattern )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org.openembedded.* org.nslu2-linux.* )

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
	[ -e optware/Makefile ] || ( cvs -q -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )

optware/nslu2/Makefile:
	${MAKE} optware/Makefile
	[ -e optware/nslu2/Makefile ]  || ( \
		mkdir -p optware/nslu2 ; \
		echo "OPTWARE_TARGET=nslu2" > optware/nslu2/Makefile ; \
	 	echo "include ../Makefile" >> optware/nslu2/Makefile ; \
		ln -s ../../downloads optware/nslu2/downloads ; \
		ln -s ../make optware/nslu2/make ; \
		ln -s ../scripts optware/nslu2/scripts ; \
		ln -s ../sources optware/nslu2/sources ; \
	)

optware/wl500g/Makefile:
	${MAKE} optware/Makefile
	[ -e optware/wl500g/Makefile ]  || ( \
		mkdir -p optware/wl500g ; \
		echo "OPTWARE_TARGET=wl500g" > optware/wl500g/Makefile ; \
	 	echo "include ../Makefile" >> optware/wl500g/Makefile ; \
		ln -s ../../downloads optware/wl500g/downloads ; \
		ln -s ../make optware/wl500g/make ; \
		ln -s ../scripts optware/wl500g/scripts ; \
		ln -s ../sources optware/wl500g/sources ; \
	)

.PHONY: setup-optware-developer
setup-optware-developer:
	${MAKE} downloads
	[ ! -e optware ] || ( mv optware optware-user )
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co -d optware unslung
	${MAKE} optware/nslu2/Makefile optware/wl500g/Makefile

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
	( cd optware ; cvs -q update -d -P )

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
push: push-master push-bitbake push-openembedded

.PHONY: push-master
push-master: update-master
	monotone push
	scp Makefile nslu@www.nslu2-linux.org:public_html/Makefile

.PHONY: push-bitbake
push-bitbake: update-bitbake
	( cd bitbake ; monotone push )

.PHONY: push-openembedded
push-openembedded: update-openembedded
	( cd openembedded ; monotone push )

# Targets for use by core team members only

.PHONY: upload
upload: upload-openslug-cross upload-unslung-modules upload-optware-nslu2-cross upload-optware-wl500g-cross upload-sources

.PHONY: upload-openslug-cross
upload-openslug-cross: openslug/Makefile
	rsync -vlrt --exclude='Packages*' openslug/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_ipk openslug/cross
	rsync -vl openslug/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	rsync -vlrt --delete openslug/tmp/deploy/ipk/ unslung@ipkg.nslu2-linux.org:nslu/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_packages_clean openslug/cross

.PHONY: upload-unslung-modules
upload-unslung-modules: unslung/Makefile
	scripts/package-strip.pl kernel-module-\* unslung/tmp/deploy/ipk/Packages unslung/tmp/deploy/ipk/Packages.new
	mv unslung/tmp/deploy/ipk/Packages.new unslung/tmp/deploy/ipk/Packages
	rm -f unslung/tmp/deploy/ipk/Packages.gz
	gzip -c unslung/tmp/deploy/ipk/Packages > unslung/tmp/deploy/ipk/Packages.gz
	rsync -vlt unslung/tmp/deploy/ipk/kernel-module-* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_ipk unslung/oe
	rsync -vl unslung/tmp/deploy/ipk/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_packages_clean unslung/oe
#	rsync -vlt --delete unslung/tmp/deploy/ipk/kernel-module-* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/oe/

.PHONY: upload-optware-nslu2-cross
upload-optware-nslu2-cross: optware/nslu2/Makefile
	rsync -vlrt --exclude='Packages*' optware/nslu2/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_ipk unslung/cross
	rsync -vl optware/nslu2/packages/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	rsync -vlrt --delete optware/nslu2/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/cross/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_packages_clean unslung/cross

.PHONY: upload-optware-wl500g-cross
upload-optware-wl500g-cross: optware/wl500g/Makefile
	rsync -vlrt --exclude='Packages*' optware/wl500g/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_ipk unslung/wl500g
	rsync -vl optware/wl500g/packages/Packages* unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	rsync -vlrt --delete optware/wl500g/packages/ unslung@ipkg.nslu2-linux.org:nslu/feeds/unslung/wl500g/
	ssh nslu2@sources.nslu2-linux.org mirror/sync_packages_clean unslung/wl500g

.PHONY: upload-sources
upload-sources:
	rsync -vlrt --exclude='ixp400*' downloads/ nslu2@sources.nslu2-linux.org:ipkg/sources/

.PHONY: import-bitbake
import-bitbake: bitbake/bin/bitbake
	svn co svn://svn.berlios.de/bitbake/trunk/bitbake

.PHONY: import-openembedded
import-openembedded: openembedded/conf/machine/nslu2.conf
	monotone pull monotone.vanille.de org.openembedded.*
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	monotone propagate org.openembedded.dev org.openembedded.nslu2-linux
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: export-openembedded
export-openembedded: openembedded/conf/machine/nslu2.conf
	monotone propagate org.openembedded.nslu2-linux org.openembedded.dev
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	monotone push monotone.vanille.de org.openembedded.*

.PHONY: publish-openembedded
publish-openembedded: import-openembedded update-openembedded push-openembedded export-openembedded

# End of Makefile
