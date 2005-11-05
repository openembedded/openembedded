PR         = "r0"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = "audiofile"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.tar.gz"

S = ${WORKDIR}/${PN}-0.3

datafiles = "game-chess_check.wav ui-charging_started.wav game-chess_checkmate.wav \
             ui-clock_alarm.mp3 game-chess_illegal_move.wav ui-confirmation_note.wav \
             game-chess_piece_capture.wav ui-connection_lost.wav \
             game-chess_successful_movement.wav ui-default_beep.wav \
             game-chess_successful_selection.wav ui-general_warning.wav \
             game-chess_unsuccesful_selection.wav ui-information_note.wav \
             game-mahjong_correct_combination.wav    ui-key_press.wav \
             game-mahjong_hint_usage.wav             ui-new_email.wav \
             game-mahjong_incorrect_combination.wav  ui-operation_ready.wav \
             game-mahjong_incorrect_selection.wav    ui-pen_down.wav \
             game-mahjong_shuffle_usage.wav          ui-recharge_battery.wav \
             game-mahjong_successful_selection.wav   ui-shutdown.wav \
             game-mahjong_undo_usage.wav             ui-wake_up_tune.wav \
             ui-battery_low.wav                      ui-wrong_charger.wav"

do_install () {
	install -d ${D}/${datadir}/sounds
	for h in ${datafiles}; do
		install -m 0644 ${S}/usr/share/sounds/$h ${D}/${datadir}/sounds/$h
	done
}
