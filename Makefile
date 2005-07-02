# Makefile for the NSLU2 Linux development system
# Licensed under the GPL v2 or later

.PHONY: all
all: update build

.PHONY: build
build: build-unslung build-openslug build-optware

.PHONY: setup
setup: setup-master setup-bitbake setup-openembedded setup-oe-symlinks setup-optware

.PHONY: update
update: update-master update-bitbake update-openembedded update-oe-symlinks update-optware

.PHONY: clobber
clobber: clobber-optware clobber-oe-symlinks clobber-openembedded clobber-bitbake

.PHONY: unslung build-unslung
unslung build-unslung: unslung/Makefile bitbake/bin/bitbake openembedded/conf/machine/nslu2.conf oe-symlinks/packages
	( cd unslung ; make )

.PHONY: openslug build-openslug
openslug build-openslug: openslug/Makefile bitbake/bin/bitbake openembedded/conf/machine/nslu2.conf oe-symlinks/packages
	( cd openslug ; make )

.PHONY: optware build-optware
optware build-optware: optware/Makefile
	( cd optware ; make )

.PHONY: setup-monotone
setup-monotone monotone/nslu2-linux.db:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && monotone -d monotone/nslu2-linux.db db init )
	( monotone -d monotone/nslu2-linux.db pull monotone.vanille.de org.openembedded )
	( monotone -d monotone/nslu2-linux.db unset database default-server )
	( monotone -d monotone/nslu2-linux.db unset database default-collection )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org )

unslung/Makefile openslug/Makefile: monotone/nslu2-linux.db
	[ -e MT ] || ( monotone -d monotone/nslu2-linux.db co -b org.nslu2-linux.dev . )

.PHONY: setup-master
setup-master: setup-monotone unslung/Makefile openslug/Makefile
	[ -e downloads ] || mkdir -p downloads
	[ -e unslung/downloads ]  || ( cd unslung  ; ln -s ../downloads . )
	[ -e openslug/downloads ] || ( cd openslug ; ln -s ../downloads . )

.PHONY: setup-bitbake
setup-bitbake bitbake/bin/bitbake:
	[ -e bitbake/bin/bitbake ] || ( svn co svn://svn.berlios.de/bitbake/trunk/bitbake )

.PHONY: setup-openembedded
setup-openembedded openembedded/conf/machine/nslu2.conf: monotone/nslu2-linux.db
	[ -e openembedded/conf/machine/nslu2.conf ] || monotone co -b org.openembedded.nslu2-linux openembedded

.PHONY: setup-oe-symlinks
setup-oe-symlinks oe-symlinks/packages:
	[ -e oe-symlinks/packages ] || ( svn co svn://svn.berlios.de/openslug/trunk/openslug/nslu2-linux oe-symlinks )

.PHONY: setup-optware
setup-optware optware/Makefile:
	[ -e optware/Makefile ] || ( cvs -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )
	[ -e optware/downloads ] || ( cd optware ; ln -s ../downloads . )

.PHONY: update-master
update-master: monotone/nslu2-linux.db
	monotone pull
	monotone update
	if [ `monotone automate heads org.nslu2-linux.dev | wc -l` != "1" ] ; then \
	  monotone merge -b org.nslu2-linux.dev ; \
	fi

.PHONY: update-bitbake
update-bitbake: bitbake/bin/bitbake
	( cd bitbake ; svn update )

.PHONY: update-openembedded
update-openembedded: openembedded/conf/machine/nslu2.conf
	monotone pull
	( cd openembedded ; monotone update )
	if [ `monotone automate heads org.openembedded.nslu2-linux | wc -l` != "1" ] ; then \
	  monotone merge -b org.openembedded.nslu2-linux ; \
	fi

.PHONY: update-oe-symlinks
update-oe-symlinks: oe-symlinks/packages
	( cd oe-symlinks ; svn update )

.PHONY: update-optware
update-optware: optware/Makefile
	( cd optware ; cvs update -d -P )

.PHONY: push-master
push-master: monotone/nslu2-linux.db
	monotone push

.PHONY: push-openembedded
push-openembedded: openembedded/conf/machine/nslu2.conf
	( cd openembedded ; monotone push )

.PHONY: clobber-bitbake
clobber-bitbake:
	rm -rf bitbake

.PHONY: clobber-openembedded
clobber-openembedded:
	rm -rf openembedded

.PHONY: clobber-oe-symlinks
clobber-oe-symlinks:
	rm -rf oe-symlinks

.PHONY: clobber-optware
clobber-optware:
	rm -rf optware

# Deprecated targets

unslung-build  : build-unslung
openslug-build : build-openslug
optware-build  : build-optware

# Core team use only targets

.PHONY: publish-master
publish-master: push-master
	scp Makefile www.nslu2-linux.org:/home/nslu/public_html/Makefile

.PHONY: import-openembedded
import-openembedded: openembedded/conf/machine/nslu2.conf
	monotone pull monotone.vanille.de org.openembedded
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
	monotone push monotone.vanille.de org.openembedded

.PHONY: publish-openembedded
publish-openembedded: import-openembedded propagate-from-oe update-openembedded \
		      propagate-to-oe push-openembedded export-openembedded

# End of Makefile
