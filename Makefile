# Makefile for the NSLU2 Linux development system
# Licensed under the GPL v2 or later

all: update build

build: unslung-build openslug-build optware-build

setup: monotone-setup bitbake-setup openembedded-setup oe-symlinks-setup optware-setup

update: monotone-update bitbake-update openembedded-update oe-symlinks-update optware-update

clobber: optware-clobber oe-symlinks-clobber openembedded-clobber bitbake-clobber

unslung-build:
	( cd unslung ; make )

openslug-build:
	( cd openslug ; make )

optware-build:
	( cd optware ; make )

monotone-setup monotone/nslu2-linux.db unslung/Makefile openslug/Makefile:
	[ -e monotone/nslu2-linux.db ] || ( mkdir -p monotone && monotone -d monotone/nslu2-linux.db db init )
	( monotone -d monotone/nslu2-linux.db pull monotone.vanille.de org.openembedded )
	( monotone -d monotone/nslu2-linux.db unset database default-server )
	( monotone -d monotone/nslu2-linux.db unset database default-collection )
	( monotone -d monotone/nslu2-linux.db pull monotone.nslu2-linux.org org )
	[ -e MT ] || ( monotone -d monotone/nslu2-linux.db co -b org.nslu2-linux.dev . )
	[ -e downloads ] || mkdir -p downloads
	[ -e unslung/downloads ]  || ( cd unslung  ; ln -s ../downloads . )
	[ -e openslug/downloads ] || ( cd openslug ; ln -s ../downloads . )

monotone-update: monotone/nslu2-linux.db
	monotone pull && monotone update

bitbake-setup bitbake/bin/bitbake:
	[ -e bitbake/bin/bitbake ] || ( svn co svn://svn.berlios.de/bitbake/trunk/bitbake )

bitbake-update: bitbake/bin/bitbake
	( cd bitbake ; svn update )

bitbake-clobber:
	rm -rf bitbake

openembedded-setup openembedded/conf/machine/nslu2.conf:
	[ -e openembedded/conf/machine/nslu2.conf ] || monotone co -b org.openembedded.nslu2-linux openembedded

openembedded-update: openembedded/conf/machine/nslu2.conf
	( cd openembedded ; monotone update )

openembedded-clobber:
	rm -rf openembedded

oe-symlinks-setup oe-symlinks/packages:
	[ -e oe-symlinks/packages ] || ( svn co svn://svn.berlios.de/openslug/trunk/openslug/nslu2-linux oe-symlinks )

oe-symlinks-update: oe-symlinks/packages
	( cd oe-symlinks ; svn update )

oe-symlinks-clobber:
	rm -rf oe-symlinks

optware-setup optware/Makefile:
	[ -e optware/Makefile ] || ( cvs -d :pserver:anonymous@cvs.sf.net:/cvsroot/nslu co -d optware unslung )
	[ -e optware/downloads ] || ( cd optware ; ln -s ../downloads . )

optware-update: optware/Makefile
	( cd optware ; cvs update -d -P )

optware-clobber:
	rm -rf optware

# End of Makefile
