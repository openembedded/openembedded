#------------------------------------------------------
# freesmartphone.org Image Recipe, No-x11 Edition
#------------------------------------------------------

PR = "r1.0"

require fso-image.inc

export IMAGE_BASENAME = "fso-image-nox"

# The packages below should ideally be a subset of the
# full fso-image.  But unfortunately, the granularity
# and some of the assumptions of the fso image do not
# yet permit that.  The gating factor is that this
# particular image needs to include the necessary stuff
# so that Qt Extended can run, but not so much that
# it can no longer fit in the small flash available on
# the GTA01.  So, in practice this means that we will
# need some X libs (for dbus at a minimum), but we need
# to ensure that we limit that as much as possible.
#
# (There is little doubt that as the software stacks
# mature, the GTA01 will need to become SD-card based.
# Never-the-less, it is desirable to keep this as small
# as possible for as long as possible.)
#
# Note: if packages are _added_ to this image, it is
# important to also add the -dev versions of that
# package to the toolchain, if applicable.  In general,
# _adding_ packages to this file is a bad idea; this
# image should be a proper subset of the full fso image.
#

AUDIO_NOX_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  openmoko-alsa-scenarios \
"

# python - just pull in some basics for now.  Ideally we would like
# to be able to run parts of the framework, but that's a future, and
# would almost certainly require an SD card on the GTA01.  So just
# add the basics so that we at least have a scripting language.
##
# (I'm really of two minds on this; removing python is a big
# win in terms of flash space, and I'm not sure how useful this
# small set is.  Need comments from others.  --- MJW)

PYTHON_NOX_INSTALL = "\
  python-dbus \
  python-pygobject \
"

# Tools - carefully picked so that we don't pull in too much.
# This list should be edited -- in particular, s3c24xx-gpio is large
# and statically linked.  If not needed, we can save some flash on the
# GTA01 by getting rid of it in the base image.  Other candidates
# might include nano, mdbus, powertop, sysstat, and tcpdump.

TOOLS_NOX_INSTALL = "\
  dosfstools \
  htop \
  iptables \
  lsof \
  mdbus \
  mtd-utils \
  nano \
  powertop \
  s3c24xx-gpio \
  sysstat \
  tcpdump \
"

# This block is intended to pull in stuff that is normally pulled
# in as dependencies in the full fso image.  At this moment,
# libpng12 is an exception - it slipped into the toolchain, hence
# it needs to be here as well.  It should be added to the full
# fso image at some point.

EXTRA_NOX_INSTALL = "\
  libstdc++ \
  tslib \
  pointercal \
  tzdata \
  libpng12 \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${EXTRA_NOX_INSTALL} \
  ${AUDIO_NOX_INSTALL} \
  ${PYTHON_NOX_INSTALL} \
  ${TOOLS_NOX_INSTALL} \
"

# The post-processing step for this image is where we can do some
# cleanup to get some space back if necessary, or do other touch-up
# work specific to this image.  It is currently empty, and should
# continue to be empty -- but it appears here because that's probably
# unrealistic, so we might as put the placeholder here right now.

fso_nox_rootfs_postprocess() {
  curdir=$PWD
  cd ${IMAGE_ROOTFS}
  # Execute commands to tweak the rootfs here

  # End commands
  cd ${curdir}
}

ROOTFS_POSTPROCESS_COMMAND += "fso_nox_rootfs_postprocess"
