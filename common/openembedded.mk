#!/bin/make
# Makefile for OpenEmbedded builds
# Licensed under the GPL v2 or later
#
# conf/auto.conf must exist in the same directory as the Makefile (i.e.
# the directory where Makefile is used - it may be a symbolic link to
# this file).  conf/auto.conf defines:
#
# DISTRO - the OpenEmbedded 'distro' to build
# MACHINE - the OpenEmbedded build target machine
#
# All of these values are (should be, must be) quoted in double quotes
include conf/auto.conf

BUILD_DIRS = downloads
REQUIRED_DIRS = bitbake openembedded
FIRMWARE_DEPS = create-topdir $(BUILD_DIRS) $(REQUIRED_DIRS)
BITBAKE = bitbake

# The default rule is to build everything in an unprotected environment.
distro: $(FIRMWARE_DEPS)
	. ./setup-env; exec ${BITBAKE} $(DISTRO)-packages

# The default rule is to build the firmware in an unprotected environment.
image: $(FIRMWARE_DEPS)
	. ./setup-env; exec ${BITBAKE} $(DISTRO)-image

# This rule clobbers the environment (note that ccache uses '$HOME' by
# default, so the cache will end up there).
distro-safe:
	env -i HOME="$${HOME}" PATH="$${PATH}" $(MAKE) distro

# The default rule is to build the firmware in an unprotected environment.
prefetch: $(FIRMWARE_DEPS)
	. ./setup-env; exec ${BITBAKE} -cfetch $(DISTRO)-packages

# topdir.conf is re-created automatically if the directory is
# moved - this will cause a full bitbake reparse
.PHONY: create-topdir
create-topdir: conf/topdir.conf
	. conf/topdir.conf && test "`pwd`" = "$$TOPDIR" || echo "TOPDIR='`pwd`'" > conf/topdir.conf

conf/topdir.conf:
	echo "TOPDIR='`pwd`'" >$@

# rules for directories - if a symlink exists and the target does not
# exist something will go wrong in the build, therefore cause a failure
# here by the mkdir.
$(BUILD_DIRS):
	test -d $@ || if test -d ../$@; then ln -s ../$@ .; else mkdir $@; fi

# these directories must already exist - either in TOPDIR (here) or in ..
$(REQUIRED_DIRS):
	test -d $@ || if test -d ../$@; then ln -s ../$@ .; else exit 1; fi

.PHONY: clobber
clobber:
	rm -rf tmp

.PHONY: source
source: $(REQUIRED_DIRS)
	tar zcf $(DISTRO).tar.gz --exclude=MT Makefile setup-env conf/site.conf conf/auto.conf \
		conf/local.conf.sample $(REQUIRED_DIRS:=/.)

# This target probably isn't important any longer, because the -source
# target above does the right thing
.PHONY:
distclean: clobber
	rm -rf conf/topdir.conf conf/local.conf $(BUILD_DIRS)

# This target is mainly for testing - it is intended to put the disto directory
# back to its original state, it will destroy a source-tarball system (because
# it removes directories from the tarball).
.PHONY:
really-clean: distclean
	rm -rf $(REQUIRED_DIRS) $(DISTRO)-source.tar.gz
