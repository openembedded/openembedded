require bug-app.inc

DESCRIPTION = "*Audio Module Tester*\
A tester application for audio module. Plays a wav file that is located in application's /resource directory also listens to -/+ buttons on the keyboard to mimic a rocker on the audio module."
HOMEPAGE = "http://buglabs.net/applications/AudioModuleButtonTester"

DEPENDS += "com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.common com.buglabs.osgi service-tracker "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/358"

APIVERSION = ""

BROKEN = "1"
