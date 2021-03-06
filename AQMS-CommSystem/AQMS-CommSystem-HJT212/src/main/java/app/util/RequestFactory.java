package app.util;

import core.structure.CommandPara;
import core.structure.DataPackage;
import core.structure.DataSegment;
import core.structure.DataZone;
import core.structure.IElement;
import core.structure.util.QNGenerator;

public class RequestFactory {
	private LocalInfo localInfo;
	private QNGenerator qnGen;
	private String defaultPNum = null;
	private String defaultPNo = null;
	private String defaultFlag = "3";
	private String defaultFlagstop = null;//tianjia

	public RequestFactory(LocalInfo localInfo, QNGenerator qnGen) {
		super();
		this.localInfo = localInfo;
		this.qnGen = qnGen;
	}


	public DataPackage buildRegistReq()
	{
		CommandPara cp = new CommandPara("");
		DataSegment seg = new DataSegment(qnGen.generate(), null, null, "32", "3019", "123456",
				"AAAAAAAAAAAAAA", "3", cp);
		return  new DataPackage(seg);
	}
	
	
	public DataPackage buildDataRet(String retCn,String qn, String cn ) {
		String cpString = "QN="+qn+";CN="+cn;
		DataZone dz = new DataZone(cpString);
		CommandPara cp = new CommandPara(dz);
		DataSegment seg = new DataSegment(null,null,null,"91",retCn,null,null,null,cp);
		
		return new DataPackage(seg);
	}
	
	public DataPackage buildRequest(String pNUM, String pNO, String cN, String flag, IElement cP)
	{
		DataSegment seg = new DataSegment(qnGen.generate(), pNUM, pNO, localInfo.ST, cN, localInfo.PW,
				localInfo.MN, flag, cP);
		return  new DataPackage(seg);
	}
	public DataPackage buildRequeststop(String pNUM, String pNO, String cN,String flag, IElement cP)//tianjia
	{
		DataSegment seg = new DataSegment(qnGen.generate(), pNUM, pNO, localInfo.ST, cN, localInfo.PW,
				localInfo.MN,flag, cP);
		return  new DataPackage(seg);
	}
	
	public DataPackage buildRequest(String cN, IElement cP)
	{
		return this.buildRequest(defaultPNum, defaultPNo, cN, defaultFlag , cP);
	}
	public DataPackage buildRequeststop(String cN, IElement cP)//tianjia
	{
		return this.buildRequeststop(defaultPNum, defaultPNo, cN, defaultFlagstop, cP);
	}
}
