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

HOST_FIRMWARE:=$(shell uname -m | sed \
	-e 's/i[3-9]86/Linux/' \
	-e 's/armv5teb/OpenSlug/' \
	-e 's/armv5b/Unslung/' \
	)

.PHONY: all
all: update build

.PHONY: prefetch
prefetch: prefetch-unslung prefetch-openslug prefetch-ucslugc prefetch-optware

.PHONY: build
build: build-unslung build-openslug build-ucslugc build-optware

.PHONY: setup
ifneq ($(HOST_MACHINE),armeb)
setup: setup-master setup-bitbake setup-openembedded setup-unslung setup-openslug setup-ucslugc setup-optware
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
setup: setup-master setup-bitbake setup-openembedded setup-openslug
else
setup: setup-master setup-optware
endif
endif

.PHONY: setup-developer
setup-developer: setup-master setup-bitbake setup-openembedded setup-optware-developer

.PHONY: update
ifneq ($(HOST_MACHINE),armeb)
update: update-master update-bitbake update-openembedded update-optware
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
update: update-master update-bitbake update-openembedded
else
update: update-master update-optware
endif
endif

.PHONY: status
status: status-master status-bitbake status-openembedded status-optware

.PHONY: clobber
clobber: clobber-unslung clobber-openslug clobber-ucslugc clobber-optware

.PHONY: distclean
distclean: distclean-master distclean-bitbake distclean-openembedded \
	 distclean-unslung distclean-openslug distclean-ucslugc distclean-optware distclean-releases

.PHONY: prefetch-unslung
ifneq ($(HOST_MACHINE),armeb)
prefetch-unslung: unslung/.configured bitbake/.configured openembedded/.configured
	( cd unslung ; ${MAKE} prefetch )
else
prefetch-unslung:
endif

.PHONY: prefetch-unslung-binary-kernel
ifneq ($(HOST_MACHINE),armeb)
prefetch-unslung-binary-kernel: unslung-binary-kernel/.configured bitbake/.configured openembedded/.configured
	( cd unslung-binary-kernel ; ${MAKE} prefetch )
else
prefetch-unslung-binary-kernel:
endif

.PHONY: prefetch-openslug
ifneq ($(HOST_MACHINE),armeb)
prefetch-openslug: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} prefetch )
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
prefetch-openslug: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} prefetch )
else
prefetch-openslug:
endif
endif

.PHONY: prefetch-ucslugc
ifneq ($(HOST_MACHINE),armeb)
prefetch-ucslugc: ucslugc/.configured bitbake/.configured openembedded/.configured
	( cd ucslugc ; ${MAKE} prefetch )
else
prefetch-ucslugc:
endif

.PHONY: prefetch-optware
prefetch-optware: prefetch-optware-nslu2 prefetch-optware-wl500g prefetch-optware-ds101 prefetch-optware-ds101g

.PHONY: prefetch-optware-nslu2
ifneq ($(HOST_MACHINE),armeb)
prefetch-optware-nslu2: optware/nslu2/.configured
	( cd optware/nslu2 ; ${MAKE} source )
else
ifeq ($(HOST_FIRMWARE),Unslung)
prefetch-optware-nslu2: optware/nslu2/.configured
	( cd optware/nslu2 ; ${MAKE} source )
else
prefetch-optware-nslu2:
endif
endif

.PHONY: prefetch-optware-%
ifneq ($(HOST_MACHINE),armeb)
prefetch-optware-%: optware/%/.configured
	( cd optware/$* ; ${MAKE} source )
else
prefetch-optware-%:
endif

prefetch-openslug-%-beta: releases/OpenSlug-%-beta/.configured
	( cd releases/OpenSlug-$*-beta ; ${MAKE} prefetch )

.PHONY: unslung build-unslung
ifneq ($(HOST_MACHINE),armeb)
unslung build-unslung: unslung/.configured bitbake/.configured openembedded/.configured
	( cd unslung ; ${MAKE} )
else
unslung build-unslung:
endif

.PHONY: unslung-binary-kernel build-unslung-binary-kernel
ifneq ($(HOST_MACHINE),armeb)
unslung-binary-kernel build-unslung-binary-kernel: unslung-binary-kernel/.configured bitbake/.configured openembedded/.configured
	( cd unslung-binary-kernel ; ${MAKE} )
else
unslung-binary-kernel build-unslung-binary-kernel:
endif

.PHONY: openslug build-openslug
ifneq ($(HOST_MACHINE),armeb)
openslug build-openslug: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} )
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
openslug build-openslug: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} )
else
openslug build-openslug:
endif
endif

.PHONY: ucslugc build-ucslugc
ifneq ($(HOST_MACHINE),armeb)
ucslugc build-ucslugc: ucslugc/.configured bitbake/.configured openembedded/.configured
	( cd ucslugc ; ${MAKE} )
else
ucslugc build-ucslugc:
endif

.PHONY: unslung-image build-unslung-image
ifneq ($(HOST_MACHINE),armeb)
unslung-image build-unslung-image: unslung/.configured bitbake/.configured openembedded/.configured
	( cd unslung ; ${MAKE} image)
else
unslung-image build-unslung-image:
endif

.PHONY: openslug-image build-openslug-image
ifneq ($(HOST_MACHINE),armeb)
openslug-image build-openslug-image: openslug/.configured bitbake/.configured openembedded/.configured
	( cd openslug ; ${MAKE} image )
else
openslug-image build-openslug-image:
endif

.PHONY: ucslugc-image build-ucslugc-image
ifneq ($(HOST_MACHINE),armeb)
ucslugc-image build-ucslugc-image: ucslugc/.configured bitbake/.configured openembedded/.configured
	( cd ucslugc ; ${MAKE} image)
else
ucslugc-image build-ucslugc-image:
endif

.PHONY: build-optware
build-optware: build-optware-nslu2 build-optware-wl500g build-optware-ds101 build-optware-ds101g

.PHONY: optware-nslu2 build-optware-nslu2
ifneq ($(HOST_MACHINE),armeb)
optware-nslu2 build-optware-nslu2: optware/nslu2/.configured
	( cd optware/nslu2 ; ${MAKE} autoclean ; ${MAKE} )
else
ifeq ($(HOST_FIRMWARE),Unslung)
optware-nslu2 build-optware-nslu2: optware/nslu2/.configured
	( cd optware/nslu2 ; ${MAKE} autoclean ; ${MAKE} )
else
optware-nslu2 build-optware-nslu2:
endif
endif

.PHONY: optware-wl500g build-optware-wl500g
ifneq ($(HOST_MACHINE),armeb)
optware-wl500g build-optware-wl500g: optware/wl500g/.configured
	( cd optware/wl500g ; ${MAKE} autoclean ; ${MAKE} )
else
optware-wl500g build-optware-wl500g:
endif

.PHONY: optware-ds101 build-optware-ds101
ifneq ($(HOST_MACHINE),armeb)
optware-ds101 build-optware-ds101: optware/ds101/.configured
	( cd optware/ds101 ; ${MAKE} autoclean ; ${MAKE} )
else
optware-ds101 build-optware-ds101:
endif

.PHONY: optware-ds101g build-optware-ds101g
ifneq ($(HOST_MACHINE),armeb)
optware-ds101g build-optware-ds101g: optware/ds101g/.configured
	( cd optware/ds101g ; ${MAKE} autoclean ; ${MAKE} )
else
optware-ds101g build-optware-ds101g:
endif

openslug-%-beta: update-openslug-%-beta build-openslug-%-beta upload-openslug-%-beta
	echo "$@ completed"

build-openslug-2.3-beta: releases/OpenSlug-2.3-beta/.configured
	( cd releases/OpenSlug-2.3-beta ; ${MAKE} openslug-firmware )

build-openslug-%-beta: releases/OpenSlug-%-beta/.configured
	( cd releases/OpenSlug-$*-beta ; ${MAKE} firmware )

.PHONY: setup-master
setup-master MT/.configured:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && \
	wget http://sources.nslu2-linux.org/monotone/nslu2-linux.db.gz -O monotone/nslu2-linux.db.gz && \
	gunzip monotone/nslu2-linux.db.gz )
	- ( monotone -d monotone/nslu2-linux.db unset database default-server )
	- ( monotone -d monotone/nslu2-linux.db unset database default-include-pattern )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org.{nslu2-linux.*,openembedded.dev} )
	[ -e MT/revision ] || ( monotone -d monotone/nslu2-linux.db co -b org.nslu2-linux.dev . )
	touch MT/.configured

.PHONY: setup-bitbake
setup-bitbake bitbake/.configured: MT/.configured
	[ -e bitbake/bin/bitbake ] || monotone co -b org.nslu2-linux.bitbake bitbake
	touch bitbake/.configured

.PHONY: setup-openembedded
setup-openembedded openembedded/.configured: MT/.configured
	[ -e openembedded/conf/machine/nslu2.conf ] || monotone co -b org.openembedded.dev openembedded
	touch openembedded/.configured

.PHONY: setup-optware
setup-optware optware/.configured: MT/.configured
	[ -e downloads ]        || ( mkdir -p downloads )
	[ -e optware/Makefile ] || ( cvs -q -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )
	touch optware/.configured

# This pattern rule has to come before the subsequent %/.configured openembedded pattern rule.
optware/%/.configured: optware/.configured
	[ -e optware/$*/Makefile ] || ( \
		mkdir -p optware/$* ; \
		echo "OPTWARE_TARGET=$*" > optware/$*/Makefile ; \
	 	echo "include ../Makefile" >> optware/$*/Makefile ; \
		ln -s ../../downloads optware/$*/downloads ; \
		ln -s ../make optware/$*/make ; \
		ln -s ../scripts optware/$*/scripts ; \
		ln -s ../sources optware/$*/sources ; \
	)
	touch optware/$*/.configured

.PHONY: setup-optware-developer
setup-optware-developer:
	[ ! -e optware ] || ( mv optware optware-user )
	cvs -q -d :ext:${CVS_USER}@cvs.sf.net:/cvsroot/nslu co -d optware unslung
	${MAKE} setup-optware

.PHONY: setup-unslung setup-unslung-binary-kernel setup-openslug setup-ucslugc
setup-unslung setup-unslung-binary-kernel setup-openslug setup-ucslugc: setup-%: MT/.configured
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

setup-openslug-%-beta releases/OpenSlug-%-beta/.configured:
	[ -e releases/OpenSlug-$*-beta ] || ( \
		mkdir -p releases ; \
		svn checkout svn://svn.berlios.de/openslug/releases/OpenSlug-$*-beta \
			releases/OpenSlug-$*-beta \
	)
	( cd releases/OpenSlug-$*-beta ; ${MAKE} setup-env )
	[ -e downloads ] || ( mkdir -p downloads )
	[ -e releases/OpenSlug-$*-beta/downloads ] || ln -s ../../downloads releases/OpenSlug-$*-beta/
	touch releases/OpenSlug-$*-beta/.configured

setup-openslug-%-beta-developer:
	[ -e releases/OpenSlug-$*-beta ] || ( \
		mkdir -p releases ; \
		svn checkout svn+ssh://svn.berlios.de/svnroot/repos/openslug/releases/OpenSlug-$*-beta \
			releases/OpenSlug-$*-beta \
	)
	${MAKE} setup-openslug-$*-beta

.PHONY: setup-host-debian
setup-host-debian:
	su - -c " \
	apt-get install \
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
		unzip \
		subversion \
		bzip2 ;\
	echo You will have to install monotone separately.  See http://venge.net/monotone/ \
             "

.PHONY: setup-host-ubuntu
setup-host-ubuntu:
	su - -c " \
	apt-get install \
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
		python python-dev python2.4-psyco python2.4 python2.4-dev \
		sed \
		texinfo \
		unzip \
		subversion \
		bzip2 ;\
	echo You will have to install monotone separately.  See http://venge.net/monotone/ \
		"


.PHONY: setup-host-gentoo
setup-host-gentoo:
	su - -c "mkdir -p /etc/portage ; echo >> /etc/portage/package.keywords ; \
        grep monotone-0.22 /etc/portage/package.keywords || \
	echo ~dev-util/monotone-0.22 ~* >> /etc/portage/package.keywords ; \
        grep dev-libs/boost-1.32.0 /etc/portage/package.keywords || \
	echo ~dev-libs/boost-1.32.0 ~* >> /etc/portage/package.keywords ; \
        emerge -n \
        autoconf automake \
        bison \
	ccache \
        cvs \
	flex \
	glib \
	libtool \
	m4 \
	make \
	monotone \
	patch \
	pkgconfig \
	sed \
	sys-apps/texinfo \
	unzip \
	psyco \
	subversion \
	bzip2"

.PHONY: update-master
update-master: MT/.configured
#	if [ `monotone -d monotone/nslu2-linux.db list keys nslu2-linux@nslu2-linux.org | wc -l` = 8 ] ; then \
#		monotone -d monotone/nslu2-linux.db dropkey nslu2-linux@nslu2-linux.org ; \
#	fi
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
	if grep "org.openembedded.nslu2-linux" openembedded/MT/options >/dev/null 2>&1 ; then \
	  sed -i -e 's/org.openembedded.nslu2-linux/org.openembedded.dev/' openembedded/MT/options ; \
	  monotone propagate org.openembedded.nslu2-linux org.openembedded.dev ; \
	fi
	monotone pull
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi
	( cd openembedded ; monotone update )
	if [ `monotone automate heads org.openembedded.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.dev ; \
	fi

.PHONY: update-optware
update-optware: optware/.configured
	( cd optware ; cvs -q update -d -P )

update-openslug-%-beta: releases/OpenSlug-%-beta/.configured
	( cd releases/OpenSlug-$*-beta ; svn up )

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

status-openslug-%-beta: 
	( cd releases/OpenSlug-$*-beta ; svn status )

.PHONY: clobber-unslung
clobber-unslung:
	[ ! -e unslung/Makefile ] || ( cd unslung ; ${MAKE} clobber )

.PHONY: clobber-unslung-binary-kernel
clobber-unslung-binary-kernel:
	[ ! -e unslung-binary-kernel/Makefile ] || ( cd unslung-binary-kernel ; ${MAKE} clobber )

.PHONY: clobber-openslug
clobber-openslug:
	[ ! -e openslug/Makefile ] || ( cd openslug ; ${MAKE} clobber )

.PHONY: clobber-ucslugc
clobber-ucslugc:
	[ ! -e ucslugc/Makefile ] || ( cd ucslugc ; ${MAKE} clobber )

.PHONY: clobber-optware
clobber-optware: clobber-optware-nslu2 clobber-optware-wl500g clobber-optware-ds101 clobber-optware-ds101g

.PHONY: clobber-optware-%
clobber-optware-%:
	[ ! -e optware/$*/Makefile ] || ( cd optware/$* ; ${MAKE} distclean )

.PHONY: distclean-master
distclean-master:
	rm -rf MT common downloads openslug scripts ucslugc unslung

.PHONY: distclean-bitbake
distclean-bitbake:
	rm -rf bitbake

.PHONY: distclean-openembedded
distclean-openembedded:
	rm -rf openembedded

.PHONY: distclean-unslung
distclean-unslung:
	rm -rf unslung

.PHONY: distclean-unslung-binary-kernel
distclean-unslung-binary-kernel:
	rm -rf unslung-binary-kernel

.PHONY: distclean-openslug
distclean-openslug:
	rm -rf openslug

.PHONY: distclean-ucslugc
distclean-ucslugc:
	rm -rf ucslugc

.PHONY: distclean-optware
distclean-optware:
	rm -rf optware

.PHONY: distclean-releases
distclean-releases:
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
	date
	rm -rf builderrors.log
	- ${MAKE} update                                      || echo -n " update"         >> builderrors.log
ifneq ($(HOST_MACHINE),armeb)
	- ${MAKE} build-openslug       upload-openslug        || echo -n " openslug"       >> builderrors.log
	- ${MAKE} build-ucslugc        upload-ucslugc         || echo -n " ucslugc"        >> builderrors.log
	- ${MAKE} build-unslung        upload-unslung-modules || echo -n " unslung"        >> builderrors.log
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
	rm -rf openslug/tmp/cache
	- ${MAKE} build-openslug       upload-openslug        || echo -n " openslug"       >> builderrors.log
endif
endif
ifneq ($(HOST_MACHINE),armeb)
	- ${MAKE} build-optware-nslu2  upload-optware-nslu2   || echo -n " optware/nslu2"  >> builderrors.log
	- ${MAKE} build-optware-wl500g upload-optware-wl500g  || echo -n " optware/wl500g" >> builderrors.log
#	- ${MAKE} build-optware-ds101  upload-optware-ds101   || echo -n " optware/ds101"  >> builderrors.log
	- ${MAKE} build-optware-ds101g upload-optware-ds101g  || echo -n " optware/ds101g" >> builderrors.log
else
ifeq ($(HOST_FIRMWARE),Unslung)
	- ${MAKE} build-optware-nslu2  upload-optware-nslu2   || echo -n " optware/nslu2"  >> builderrors.log
endif
endif
	- ${MAKE}                      upload-sources         || echo -n " upload-sources" >> builderrors.log

	date
	if [ -e builderrors.log ] ; then \
	  echo -n "*** Errors during autobuild:" ; \
	  cat builderrors.log ; \
	  echo " ***" ; \
	  if [ -e autobuild.log ] ; then \
	    rsync autobuild.log slug@nugabe.nslu2-linux.org:htdocs/logs/buildlogs/autobuild-`hostname`-last.txt ; \
	  fi \
	else \
	  if [ -e autobuild.log ] ; then \
	    ssh slug@nugabe.nslu2-linux.org mv htdocs/logs/buildlogs/autobuild-`hostname`-last.txt htdocs/logs/buildlogs/autobuild-`hostname`-prev.txt ; \
	    rsync autobuild.log slug@nugabe.nslu2-linux.org:htdocs/logs/buildlogs/autobuild-`hostname`-last.txt ; \
	  fi \
	fi

.PHONY: upload
ifneq ($(HOST_MACHINE),armeb)
upload: upload-openslug upload-ucslugc upload-unslung-modules \
	upload-optware-nslu2 upload-optware-wl500g upload-optware-ds101 upload-optware-ds101g upload-sources
else
ifeq ($(HOST_FIRMWARE),OpenSlug)
upload: upload-openslug upload-sources
else
ifeq ($(HOST_FIRMWARE),Unslung)
upload: upload-optware-nslu2 upload-sources
else
upload: upload-sources
endif
endif
endif

.PHONY: upload-openslug
upload-openslug: openslug/.configured
	rm -rf openslug/tmp/deploy/ipk/morgue
ifneq ($(HOST_MACHINE),armeb)
	rsync -vlrt --exclude='Packages*' openslug/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk openslug/cross/unstable
	rsync -vl openslug/tmp/deploy/ipk/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/unstable/
	rsync -vlrt --delete openslug/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean openslug/cross/unstable
else
	rsync -vlrt --exclude='Packages*' openslug/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/native/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk openslug/native/unstable
	rsync -vl openslug/tmp/deploy/ipk/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/native/unstable/
	rsync -vlrt --delete openslug/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/native/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean openslug/native/unstable
endif

upload-openslug-%-beta: releases/OpenSlug-%-beta/.configured
	rm -rf releases/OpenSlug-$*-beta/tmp/deploy/ipk/morgue
	rsync -vlrt --exclude='Packages*' releases/OpenSlug-$*-beta/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/$*-beta/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk openslug/cross/$*-beta
	rsync -vl releases/OpenSlug-$*-beta/tmp/deploy/ipk/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/$*-beta/
	rsync -vlrt --delete releases/OpenSlug-$*-beta/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/openslug/cross/$*-beta/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean openslug/cross/$*-beta

.PHONY: upload-ucslugc
upload-ucslugc: ucslugc/.configured
	rm -rf ucslugc/tmp/deploy/ipk/morgue
	rsync -vlrt --exclude='Packages*' ucslugc/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/ucslugc/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk ucslugc/cross/unstable
	rsync -vl ucslugc/tmp/deploy/ipk/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/ucslugc/cross/unstable/
	rsync -vlrt --delete ucslugc/tmp/deploy/ipk/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/ucslugc/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean ucslugc/cross/unstable

.PHONY: upload-unslung-modules
upload-unslung-modules: unslung/.configured
	rm -rf unslung/tmp/deploy/ipk/morgue
	scripts/package-strip.pl kernel-module-\* unslung/tmp/deploy/ipk/Packages unslung/tmp/deploy/ipk/Packages.new
	mv unslung/tmp/deploy/ipk/Packages.new unslung/tmp/deploy/ipk/Packages
	rm -f unslung/tmp/deploy/ipk/Packages.gz
	gzip -c unslung/tmp/deploy/ipk/Packages > unslung/tmp/deploy/ipk/Packages.gz
	rsync -vlt unslung/tmp/deploy/ipk/kernel-module-* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/unslung/modules/stable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk unslung/modules/stable
	rsync -vl unslung/tmp/deploy/ipk/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/unslung/modules/stable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean unslung/modules/stable
#	rsync -vlt --delete unslung/tmp/deploy/ipk/kernel-module-* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/unslung/modules/stable/

.PHONY: upload-optware-nslu2
upload-optware-nslu2: optware/nslu2/.configured
ifneq ($(HOST_MACHINE),armeb)
	rsync -vlrt --exclude='Packages*' optware/nslu2/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk optware/nslu2/cross/unstable
	rsync -vl optware/nslu2/packages/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/cross/unstable/
	rsync -vlrt --delete optware/nslu2/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean optware/nslu2/cross/unstable
else
	rsync -vlrt --exclude='Packages*' optware/nslu2/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/native/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk optware/nslu2/native/unstable
	rsync -vl optware/nslu2/packages/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/native/unstable/
	rsync -vlrt --delete optware/nslu2/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/nslu2/native/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean optware/nslu2/native/unstable
endif

.PHONY: upload-optware-%
upload-optware-%: optware/%/.configured
	rsync -vlrt --exclude='Packages*' optware/$*/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/$*/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-ipk optware/$*/cross/unstable
	rsync -vl optware/$*/packages/Packages* slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/$*/cross/unstable/
	rsync -vlrt --delete optware/$*/packages/ slug@nugabe.nslu2-linux.org:htdocs/ipkg/feeds/optware/$*/cross/unstable/
	ssh nslu2@sources.nslu2-linux.org mirror/sync-packages-clean optware/$*/cross/unstable

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

# End of Makefile
