DESCRIPTION = "SHR Lite Image Feed"
PR = "r5"
PV = "2.0"
LICENSE = "GPL"

inherit task

def get_rdepends(bb, d):
    enabled = bb.data.getVar("ENABLE_BINARY_LOCALE_GENERATION", d, 1)

    # If locale is disabled, bail out
    if not enabled:
        return

    locales = bb.data.getVar("GLIBC_GENERATE_LOCALES", d, 1)
    if not locales or locales == "all":
        locales = bb.data.getVar("IMAGE_LINGUAS", d, 1);


    import re

    rdepends = ""
    if not locales or locales == "all":
        # if locales aren't specified, or user has written "all"
        import os
        ipkdir = bb.data.getVar('DEPLOY_DIR_IPK', d, 1)

        regexp1 = re.compile("glibc-binary-localedata-.*") # search pattern
        regexp2 = re.compile("_.*") # we want to remove all version info and file extension

        for root, subFolders, files in os.walk(ipkdir):
            for file in files:
                if regexp1.search(file):
                    file = regexp2.sub("", file)
                    rdepends = "%s %s" % (rdepends, file)

    else:
        # if locales are specified
        regexp1 = re.compile("\\..*") # We want to turn en_US.UTF-8 into en_US
        regexp2 = re.compile("_")     # We want to turn en_US into en-US


        for locale in locales.split(" "):
            locale = regexp1.sub("", locale)
            locale = regexp2.sub("-", locale)
            locale = str.lower(locale)
            rdepends = "%s glibc-binary-localedata-%s" % (rdepends, locale)
    return rdepends




PACKAGES += "\
	${PN}-base \
	${PN}-fso \
	${PN}-audio \
	${PN}-x \
	${PN}-apps \
	${PN}-gtk \
"



RDEPENDS_${PN}-base = "\
  netbase \
  sysfsutils \
  modutils-initscripts \
  module-init-tools-depmod \
  rsync \
  screen \
  fbset \
  fbset-modes \
  openssh-sftp-server \
  cron \
  logrotate\
  util-linux-fdisk \
  shr-splash \
"

RDEPENDS_${PN}-fso = "\
  python-codecs \
  python-gst \
"


RDEPENDS_${PN}-audio = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  gst-plugin-mad \
  gst-plugin-modplug \
  gst-plugin-sid \
  fso-sounds \
"

RDEPENDS_${PN}-audio_append_om-gta01 = "\
  openmoko-alsa-scenarios \
"

RDEPENDS_${PN}-audio_append_om-gta02 =  "\
  openmoko-alsa-scenarios \
"

RDEPENDS_${PN}-x = "\
  glibc-utils \
  glibc-charmap-utf-8 \
  e-wm-config-illume-shr \
  e-wm-theme-illume-shr \
  ${@get_rdepends(bb, d)} \
  libx11-locale \
  localedef \
"

RDEPENDS_${PN}-apps = "\
  shr-dialer \
  shr-messages \
  shr-contacts \
  ophonekitd \ 
  libframeworkd-phonegui-efl \
  rxvt-unicode \
  elementary-alarm \
  shr-settings \
  shr-theme \
  calc \
"


RDEPENDS_${PN}-gtk = "\
  openmoko-icon-theme-standard2 \
  shr-theme-gtk-e17lookalike \
  gpe-filemanager \
  vala-terminal \
  tangogps \
  pyphonelog \
"

