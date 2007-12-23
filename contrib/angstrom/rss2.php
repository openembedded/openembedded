<?php

/*
 * This generator expect only log from autobuilder in simple format:
 * TIME_OF_BUILD BUILD_TARGET BUILD_MODE MACHINE
 *
 * where TIME_OF_BUILD is epoch
 *
 * All what it does is parsing log and output it in reverse order (new builds 
 * first) in RSS 2.0 format.
 *
 * (C) 2007 Marcin Juszkiewicz
 *
 * License: MIT
 *
 */

$build_link_base = 'http://www.angstrom-distribution.org/unstable/autobuild/';

$builder_log_date = file('autobuilder.log');

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

$rss_xml->writeElement('title', 'Ångström autobuilder updates');
$rss_xml->writeElement('link', $build_link_base);
$rss_xml->writeElement('description', 'Ångström autobuilder updates list');

foreach($builder_log_date as $build)
{
	$build = str_replace("\n", "", $build);
	$data = explode(' ', $build);

	$rss_xml->startElement('item');
	$rss_xml->writeElement('title', "{$data[1]} ({$data[2]}) built for {$data[3]}");
	$rss_xml->writeElement('link', "{$build_link_base}{$data[3]}/");
	$rss_xml->writeElement('pubDate', date('r', $data[0]));

	$rss_xml->endElement();
}

$rss_xml->endElement();
$rss_xml->endElement();

echo $rss_xml->outputMemory(true);   

echo "\n";
?>
