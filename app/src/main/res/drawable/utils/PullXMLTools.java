package com.huanchong.pet.utils;

import com.huanchong.pet.entity.City;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PullXMLTools {

	public PullXMLTools() {

	}

	public static List<City> parserXML(InputStream inputStream, String code)
			throws XmlPullParserException, IOException {
		List<City> listcity = null;
		City city = null;

		// 创建�?个xml解析的工�?
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

		// 获得XML解析类的引用
		XmlPullParser parser = factory.newPullParser();
		parser.setInput(inputStream, code);
		// 获得事件的类�?
		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				listcity = new ArrayList<>();
				break;
			case XmlPullParser.START_TAG:
				if ("City".equals(parser.getName())) {
					city = new City();
					city.setCity(parser.getAttributeValue(0));
					listcity.add(city);
				}
				break;
			case XmlPullParser.END_TAG:
				break;
			case XmlPullParser.END_DOCUMENT:

				break;

			default:
				break;

			}
			eventType = parser.next();
		}

		return listcity;
	}

}
