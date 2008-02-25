<?php

/*
 * This generator expects only log from the feed sorter in a simple format:
 * TIME FILENAME <LIBC TYPE> 
 *
 * where TIME_OF_BUILD is epoch
 *
 * All what it does is parsing log and output it in reverse order (new packages 
 * first) in RSS 2.0 format.
 *
 * (C) 2007 Marcin Juszkiewicz
 * (C) 2008 Koen Kooi
 *
 * License: MIT
 *
 */

$build_link_base = 'http://www.angstrom-distribution.org/repo/';

$builder_log_date = file('upload.txt');

if(empty($builder_log_date))
	die("No logs\n");

$builder_log_date = array_reverse($builder_log_date);

$rss_xml = new xmlWriter();

if(!$rss_xml)
	die("Unable to create XML Writer\n");

$rss_xml->openMemory();

$rss_xml->startDocument('1.0','utf-8');
$rss_xml->startElement('rss');
$rss_xml->writeAttribute('version', '2.0');

$rss_xml->startElement('channel');

$rss_xml->writeElement('title', 'Ångström package repository updates');
$rss_xml->writeElement('link', $build_link_base);
$rss_xml->writeElement('description', 'Ångström feed updates list');

foreach($builder_log_date as $build)
{
	$build = str_replace("\n", "", $build);
	$data = explode(' ', $build);
	# $date[1] is in the form of: angstrom-feed-configs-dbg_1.0-r3_palmz72.ipk
        $pkgdata = explode('_', $data[1]);

	$rss_xml->startElement('item');
	$rss_xml->writeElement('title', "{$pkgdata[0]} {$pkgdata[1]} for {$pkgdata[2]}");
	$rss_xml->writeElement('link', "{$build_link_base}?action=details&pnm={$pkgdata[0]}");
	$rss_xml->writeElement('pubDate', date('r', $data[0]));

	$rss_xml->endElement();
}

$rss_xml->endElement();
$rss_xml->endElement();

echo $rss_xml->outputMemory(true);   

echo "\n";
?>
