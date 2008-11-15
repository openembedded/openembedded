#------------------------------------------------------
# FSO compliant Illume Image Recipe
#------------------------------------------------------

require fso-image.bb

PV = "1.0"
PR = "r1"

# no languages for now
IMAGE_LINGUAS = ""

BASE_INSTALL = "\
  task-base \
"

ILLUME_THEME = "illume-theme-fso"

X_INSTALL = "\
  task-x11-illume \
  task-fonts-truetype-core \
"

X_INSTALL_append_om-gta02 = "\
  task-fonts-truetype-chinese \
  task-fonts-truetype-japanese \
"

# tools
TOOLS_INSTALL = "\
  task-cli-tools \
  task-cli-tools-python \
"

# audio
AUDIO_INSTALL = "\
  alsa-oss \
  alsa-state \
  alsa-utils-aplay \
  alsa-utils-amixer \
  gst-meta-audio \
  gst-plugin-modplug \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'gst-plugin-sid', d)} \
  fso-sounds \
"

GTK_INSTALL = "\
  xterm \
  gpe-scap \
"

# FIXME these should rather be part of alsa-state,
# once Om stabilizes them...
AUDIO_INSTALL_append_om-gta01 = "\
  openmoko-alsa-scenarios \
"
AUDIO_INSTALL_append_om-gta02 = "\
  openmoko-alsa-scenarios \
"

# python
PYTHON_INSTALL = "\
  task-python-efl \
  python-codecs \
  python-gst \
"

# fso
FSO_INSTALL = "\
  task-fso-compliance \
"

IMAGE_INSTALL = "\
  ${BASE_INSTALL} \
  ${X_INSTALL} \
  ${GTK_INSTALL} \
  ${GAMES_INSTALL} \
  ${AUDIO_INSTALL} \
  ${TOOLS_INSTALL} \
  ${PYTHON_INSTALL} \
  ${FSO_INSTALL} \
"
