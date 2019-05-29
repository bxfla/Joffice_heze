package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */

public class ExaminationData implements Serializable {


    /**
     * success : true
     * data : [{"id":1,"examinationId":"45","questionId":2755,"title":"中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入_____的关键时期召开的一次十分重要的大会。\n","typeId":4,"typeName":"单选题","content0":"A:新时期","content1":"B:新阶段","content2":"C:新征程","content3":"D:新时代","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":2,"examinationId":"45","questionId":2756,"title":"十九大的主题是：不忘初心，____，高举中国特色社会主义伟大旗帜，决胜全面建成小康社会，夺取新时代中国特色社会主义伟大胜利，为实现中华民族伟大复兴的中国梦不懈奋斗。","typeId":4,"typeName":"单选题","content0":"A:继续前进","content1":"B:牢记使命","content2":"C:方得始终","content3":"D:砥砺前行","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":3,"examinationId":"45","questionId":2757,"title":"中国共产党人的初心和使命，就是为中国人民____，为中华民族____。这个初心和使命是激励中国共产党人不断前进的根本动力。\r\n","typeId":4,"typeName":"单选题","content0":"A:谋幸福，谋未来","content1":"B:谋生活，谋复兴","content2":"C:谋幸福，谋复兴","content3":"D:谋生活，谋未来","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":4,"examinationId":"45","questionId":2758,"title":"五年来，我们统筹推进\u201c____\u201d总体布局、协调推进\u201c____\u201d战略布局，\u201c十二五\u201d规划胜利完成，\u201c十三五\u201d规划顺利实施，党和国家事业全面开创新局面。\r\n","typeId":4,"typeName":"单选题","content0":"A:五位一体　四个全面","content1":"B:四位一体　五个全面","content2":"C:五个全面　四位一体","content3":"D:四个全面　五位一体","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":5,"examinationId":"45","questionId":2759,"title":"过去五年，经济保持中高速增长，在世界主要国家中名列前茅，国内生产总值从五十四万亿元增长到____万亿元，稳居世界第二，对世界经济增长贡献率超过百分之三十。\r\n","typeId":4,"typeName":"单选题","content0":"A:六十","content1":"B:七十","content2":"C:八十","content3":"D:九十","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":6,"examinationId":"45","questionId":2760,"title":"脱贫攻坚战取得决定性进展，____贫困人口稳定脱贫，贫困发生率从百分之十点二下降到百分之四以下。\r\n","typeId":4,"typeName":"单选题","content0":"A:六千多万","content1":"B:七千多万","content2":"C:八千多万","content3":"D:九千多万","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":7,"examinationId":"45","questionId":2761,"title":"实施共建\u201c一带一路\u201d倡议，发起创办亚洲基础设施投资银行，设立丝路基金，举办首届\u201c一带一路\u201d国际合作高峰论坛、亚太经合组织领导人非正式会议、二十国集团领导人____峰会、金砖国家领导人____会晤、亚信峰会。\n","typeId":4,"typeName":"单选题","content0":"A:北京　南京","content1":"B:杭州　厦门","content2":"C:南京　北京","content3":"D:厦门　杭州","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":8,"examinationId":"45","questionId":2762,"title":"坚持反腐败无禁区、全覆盖、零容忍，坚定不移\u201c打虎\u201d、\u201c拍蝇\u201d、\u201c猎狐\u201d，____的目标初步实现，____的笼子越扎越牢，____的堤坝正在构筑，反腐败斗争压倒性态势已经形成并巩固发展。\n\n","typeId":4,"typeName":"单选题","content0":"A:不敢腐　不能腐　不想腐","content1":"B:不能腐　不敢腐　不想腐","content2":"C:不想腐　不敢腐　不能腐","content3":"D:不敢腐　不想腐　不能腐","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":9,"examinationId":"45","questionId":2763,"title":"经过长期努力，中国特色社会主义进入了新时代，这是我国发展新的____。\n\n","typeId":4,"typeName":"单选题","content0":"A:未来方向","content1":"B:未来方位","content2":"C:历史方向","content3":"D:历史方位","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":10,"examinationId":"45","questionId":2764,"title":"中国特色社会主义进入新时代，我国社会主要矛盾已经转化为人民日益增长的____需要和____的发展之间的矛盾。\n\n","typeId":4,"typeName":"单选题","content0":"A:美好生活　不充分不平衡","content1":"B:幸福生活　不平衡不充分","content2":"C:幸福生活　不充分不平衡","content3":"D:美好生活　不平衡不充分","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":11,"examinationId":"45","questionId":2765,"title":"必须认识到，我国社会主要矛盾的变化，没有改变我们对我国社会主义所处历史阶段的判断，我国仍处于并将长期处于____的基本国情没有变，我国是世界最大发展中国家的国际地位没有变。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:社会主义阶段","content1":"B:社会主义初级阶段","content2":"C:社会主义中级阶段","content3":"D:社会主义高级阶段","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":12,"examinationId":"45","questionId":2766,"title":"_____是实现社会主义现代化、创造人民美好生活的必由之路。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:中国特色社会主义道路","content1":"B:中国特色社会主义理论体系","content2":"C:中国特色社会主义制度","content3":"D:中国特色社会主义文化","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":13,"examinationId":"45","questionId":2767,"title":"_____是指导党和人民实现中华民族伟大复兴的正确理论。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:中国特色社会主义道路","content1":"B:中国特色社会主义理论体系","content2":"C:中国特色社会主义制度","content3":"D:中国特色社会主义文化","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":14,"examinationId":"45","questionId":2768,"title":"_____是当代中国发展进步的根本制度保障。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:中国特色社会主义道路","content1":"B:中国特色社会主义理论体系","content2":"C:中国特色社会主义制度","content3":"D:中国特色社会主义文化","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":15,"examinationId":"45","questionId":2769,"title":"_____是激励全党全国各族人民奋勇前进的强大精神力量。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:中国特色社会主义道路","content1":"B:中国特色社会主义理论体系","content2":"C:中国特色社会主义制度","content3":"D:中国特色社会主义文化","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":16,"examinationId":"45","questionId":2770,"title":"新时代中国特色社会主义思想，明确坚持和发展中国特色社会主义，总任务是实现社会主义现代化和中华民族伟大复兴，在全面建成小康社会的基础上，分____在本世纪中叶建成富强民主文明和谐美丽的社会主义现代化强国。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:两步走","content1":"B:三步走","content2":"C:四步走","content3":"D:五步走","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":17,"examinationId":"45","questionId":2771,"title":"新时代中国特色社会主义思想，明确中国特色社会主义最本质的特征是____。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:\u201c五位一体\u201d总体布局","content1":"B:建设中国特色社会主义法治体系","content2":"C:人民利益为根本出发点","content3":"D:中国共产党领导","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":18,"examinationId":"45","questionId":2772,"title":"发展是解决我国一切问题的基础和关键，发展必须是科学发展，必须坚定不移贯彻____的发展理念。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:创新、协调、绿色、开放、共享","content1":"B:创造、协调、生态、开放、共享","content2":"C:创新、统筹、绿色、开放、共享","content3":"D:创造、统筹、生态、开放、共享","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":19,"examinationId":"45","questionId":2773,"title":"___是中国特色社会主义的本质要求和重要保障。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:全面依法治国","content1":"B:全面从严治党","content2":"C:全面发展经济","content3":"D:全面可持续发展","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":20,"examinationId":"45","questionId":2774,"title":"___是一个国家、一个民族发展中更基本、更深沉、更持久的力量。\n\n","typeId":4,"typeName":"单选题","content0":"A:道路自信","content1":"B:理论自信","content2":"C:制度自信","content3":"D:文化自信","answer":"D","score":"1","value":"","data":"","pic":""},{"id":21,"examinationId":"45","questionId":2775,"title":"必须统筹国内国际两个大局，始终不渝走和平发展道路、奉行____的开放战略。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:互利共赢","content1":"B:互相合作","content2":"C:包容互信","content3":"D:开放共赢","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":22,"examinationId":"45","questionId":2776,"title":"从现在到二〇二〇年，是全面建成小康社会______。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:决战期","content1":"B:决胜期","content2":"C:关键期","content3":"D:攻坚期","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":23,"examinationId":"45","questionId":2777,"title":"从____到____，是\u201c两个一百年\u201d奋斗目标的历史交汇期。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:二〇二〇年　二〇三五年 ","content1":"B:十九大　二十大","content2":"C:二十大　二十一大 ","content3":"D:二〇三五年　本世纪中叶","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":24,"examinationId":"45","questionId":2778,"title":"综合分析国际国内形势和我国发展条件，从二〇二〇年到本世纪中叶可以分两个阶段来安排。第一个阶段，从______到______，在全面建成小康社会的基础上，再奋斗十五年，基本实现社会主义现代化。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:二〇二〇年　二〇三五年 ","content1":"B:二〇二五年　二〇四〇年 ","content2":"C:二〇三〇年　二〇四五年","content3":"D:二〇三五年　本世纪中叶","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":25,"examinationId":"45","questionId":2779,"title":"综合分析国际国内形势和我国发展条件，从二〇二〇年到本世纪中叶可以分两个阶段来安排。第二个阶段，从_____到_____，在基本实现现代化的基础上，再奋斗十五年，把我国建成富强民主文明和谐美丽的社会主义现代化强国。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:二〇二〇年　二〇三五年 ","content1":"B:二〇三五年　二〇五〇年","content2":"C:二〇三〇年　二〇四五年 ","content3":"D:二〇三五年　本世纪中叶","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":26,"examinationId":"45","questionId":2780,"title":"从全面建成小康社会到基本实现现代化，再到全面建成____，是新时代中国特色社会主义发展的战略安排。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:创新型国家 ?","content1":"B:社会主义现代化强国 ","content2":"C:社会主义现代化大国 ?","content3":"D:世界一流强国","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":27,"examinationId":"45","questionId":2781,"title":"实现\u201c两个一百年\u201d奋斗目标、实现中华民族伟大复兴的中国梦，不断提高人民生活水平，必须坚定不移把_____作为党执政兴国的第一要务。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:创新","content1":"B:改革","content2":"C:发展","content3":"D:开放","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":28,"examinationId":"45","questionId":2782,"title":"我国经济已由______阶段转向______阶段，正处在转变发展方式、优化经济结构、转换增长动力的攻关期，建设现代化经济体系是跨越关口的迫切要求和我国发展的战略目标。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:高速增长　高水平发展 ","content1":"B:高速发展　高水平发展 ???","content2":"C:高速增长　高质量发展","content3":"D:高速发展　高质量发展","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":29,"examinationId":"45","questionId":2783,"title":"贯彻新发展理念，建设现代化经济体系，必须坚持质量第一、效益优先，以_______为主线。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:转变发展方式","content1":"B:优化经济结构","content2":"C:供给侧结构性改革 ","content3":"D:转换增长动力","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":30,"examinationId":"45","questionId":2784,"title":"建设现代化经济体系，必须把发展经济的着力点放在______上，把提高供给体系质量作为主攻方向，显著增强我国经济质量优势。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:实体经济","content1":"B:共享经济 ","content2":"C:虚拟经济","content3":"D:国民经济","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":31,"examinationId":"45","questionId":2785,"title":"______是引领发展的第一动力，是建设现代化经济体系的战略支撑。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:改革","content1":"B:创新","content2":"C:开放","content3":"D:科技","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":32,"examinationId":"45","questionId":2786,"title":"保持土地承包关系稳定并长久不变，第二轮土地承包到期后再延长_____年。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:二十","content1":"B:三十","content2":"C:四十","content3":"D:五十","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":33,"examinationId":"45","questionId":2787,"title":"确保到______我国现行标准下农村贫困人口实现脱贫，贫困县全部摘帽，解决区域性整体贫困，做到脱真贫、真脱贫。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:二〇三〇年 ","content1":"B:二〇二〇年","content2":"C:二〇二五年","content3":"D:二〇三五年","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":34,"examinationId":"45","questionId":2788,"title":"加快完善社会主义市场经济体制。经济体制改革必须以________和________为重点，实现产权有效激励、要素自由流动、价格反应灵活、竞争公平有序、企业优胜劣汰。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:完善产权制度　要素市场化配置 ","content1":"B:要素市场化配置　建立现代财政制度","content2":"C:建立现代财政制度　创新和完善宏观调控? ","content3":"D:完善产权制度　创新和完善宏观调控","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":35,"examinationId":"45","questionId":2789,"title":"推动形成全面开放新格局。要以_____建设为重点，坚持引进来和走出去并重，遵循共商共建共享原则，加强创新能力开放合作，形成陆海内外联动、东西双向互济的开放格局。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:\u201c金砖机制\u201d","content1":"B:自贸区","content2":"C:\u201c一带一路\u201d","content3":"D:区域合作","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":36,"examinationId":"45","questionId":2790,"title":"坚持党的领导、人民当家作主、依法治国有机统一。_______是社会主义民主政治的本质特征。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:党的领导","content1":"B:人民当家作主","content2":"C:依法治国","content3":"D:政治体制改革","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":37,"examinationId":"45","questionId":2791,"title":"加强人民当家作主制度保障。______是坚持党的领导、人民当家作主、依法治国有机统一的根本政治制度安排。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:人民代表大会制度 ","content1":"B:多党合作和政治协商制度","content2":"C:民族区域自治制度 ","content3":"D:基层群众自治制度","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":38,"examinationId":"45","questionId":2792,"title":"发挥社会主义协商民主重要作用。______是具有中国特色的制度安排，是社会主义协商民主的重要渠道和专门协商机构。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:政党协商","content1":"B:人大协商","content2":"C:基层协商","content3":"D:人民政协","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":39,"examinationId":"45","questionId":2793,"title":"深化依法治国实践。成立中央全面______领导小组，加强对法治中国建设的统一领导。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:深化改革","content1":"B:依法治国","content2":"C:从严治党","content3":"D:司法改革","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":40,"examinationId":"45","questionId":2794,"title":"深化机构和行政体制改革。转变政府职能，深化简政放权，创新监管方式，增强政府公信力和执行力，建设人民满意的______政府。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:法治","content1":"B:创新型","content2":"C:廉洁","content3":"D:服务型","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":41,"examinationId":"45","questionId":2795,"title":"全党必须牢记，______的问题，是检验一个政党、一个政权性质的试金石。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:为什么人","content1":"B:执政宗旨","content2":"C:建党宗旨","content3":"D:权力来源","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":42,"examinationId":"45","questionId":2796,"title":"建设______是中华民族伟大复兴的基础工程。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:经济强国","content1":"B:政治强国","content2":"C:教育强国","content3":"D:文化强国","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":43,"examinationId":"45","questionId":2797,"title":"国家安全是安邦定国的重要基石，______是全国各族人民根本利益所在。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:加快经济发展","content1":"B:维护国家统一","content2":"C:促进国际合作","content3":"D:维护国家安全","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":44,"examinationId":"45","questionId":2798,"title":"我们要建设的现代化是人与自然_____的现代化。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:和谐相处","content1":"B:和睦相处","content2":"C:和谐共生","content3":"D:和睦共生","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":45,"examinationId":"45","questionId":2799,"title":"加快建立绿色生产和消费的法律制度和政策导向，建立健全____的经济体系。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:绿色低碳循环发展","content1":"B:绿色节约循环发展","content2":"C:绿色低碳节约发展","content3":"D:节约低碳循环发展","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":46,"examinationId":"45","questionId":2800,"title":"我们要牢固树立社会主义生态文明观，推动形成______现代化建设新格局，为保护生态环境作出我们这代人的努力！\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:人与自然和谐共生","content1":"B:人与环境和谐发展","content2":"C:人与自然和谐发展","content3":"D:人与环境和谐共生","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":47,"examinationId":"45","questionId":2801,"title":"适应世界新军事革命发展趋势和国家安全需求，提高建设质量和效益，确保到二〇二〇年基本实现____，____建设取得重大进展，____有大的提升。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:现代化　信息化　战斗能力","content1":"B:机械化　信息化　战斗能力","content2":"C:机械化　信息化　战略能力","content3":"D:现代化　信息化　战略能力","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":48,"examinationId":"45","questionId":2802,"title":"力争到二〇三五年____国防和军队现代化，到本世纪中叶把人民军队____世界一流军队。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:全面实现　基本建成","content1":"B:全面实现　全面建成","content2":"C:基本实现　基本建成","content3":"D:基本实现　全面建成","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":49,"examinationId":"45","questionId":2803,"title":"树立____是核心战斗力的思想，推进重大技术创新、自主创新，加强军事人才培养体系建设，建设创新型人民军队。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:创新","content1":"B:科技","content2":"C:人才","content3":"D:技术","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":50,"examinationId":"45","questionId":2804,"title":"军队是要准备打仗的，一切工作都必须坚持____标准，向能打仗、打胜仗聚焦。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:战斗力","content1":"B:斗争力","content2":"C:战争力","content3":"D:硬实力","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":51,"examinationId":"45","questionId":2805,"title":"解决台湾问题、实现祖国完全统一，是全体中华儿女____，是中华民族____所在。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:一致愿望　根本利益","content1":"B:共同愿望　本质利益","content2":"C:一致愿望　本质利益","content3":"D:共同愿望　根本利益","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":52,"examinationId":"45","questionId":2806,"title":"______是两岸关系的政治基础。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:\u201c九二共识\u201d","content1":"B:反对\u201c台独\u201d","content2":"C:一个中国原则","content3":"D:和平统一","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":53,"examinationId":"45","questionId":2807,"title":"我们呼吁，各国人民同心协力，构建人类命运共同体，建设______的世界。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:持久和平、普遍安全、共同繁荣、开放包容、公平正义","content1":"B:持久和平、普遍安全、共同繁荣、公平正义、清洁美丽","content2":"C:持久和平、普遍安全、共同繁荣、开放包容、清洁美丽","content3":"D:持久和平、普遍安全、公平正义、开放包容、清洁美丽","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":54,"examinationId":"45","questionId":2808,"title":"深刻认识党面临的________的尖锐性和严峻性，坚持问题导向，保持战略定力，推动全面从严治党向纵深发展。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:精神懈怠危险、能力不足危险、脱离群众危险、消极腐败危险","content1":"B:精神懈怠危险、封闭僵化危险、脱离群众危险、消极腐败危险","content2":"C:精神懈怠危险、能力不足危险、官僚主义危险、消极腐败危险","content3":"D:精神懈怠危险、能力不足危险、脱离群众危险、腐化堕落危险","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":55,"examinationId":"45","questionId":2809,"title":"党的____是党的根本性建设，决定党的建设方向和效果。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:思想建设","content1":"B:政治建设","content2":"C:组织建设","content3":"D:制度建设","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":56,"examinationId":"45","questionId":2810,"title":"要尊崇党章，严格执行新形势下党内政治生活若干准则，增强党内政治生活的____。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:政治性、时代性、原则性、战斗性","content1":"B:思想性、政治性、时代性、原则性","content2":"C:政治性、思想性、时代性、原则性","content3":"D:政治性、思想性、时代性、战斗性","content4":"E:","content5":"F:","answer":"A","score":"1","value":"","data":""},{"id":57,"examinationId":"45","questionId":2811,"title":"坚决防止和反对_________，坚决防止和反对宗派主义、圈子文化、码头文化，坚决反对搞两面派、做两面人。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:个人主义、享乐主义、自由主义、本位主义、好人主义","content1":"B:个人主义、分散主义、山头主义、本位主义、好人主义","content2":"C:个人主义、分散主义、自由主义、本位主义、好人主义","content3":"D:个人主义、分散主义、自由主义、本位主义、享乐主义","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":58,"examinationId":"45","questionId":2812,"title":"____和_____，是中国共产党人的精神支柱和政治灵魂，也是保持党的团结统一的思想基础。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:共产主义远大理想　新时代中国特色社会主义共同理想","content1":"B:共产主义远大理想　中国特色社会主义共同理想","content2":"C:共产主义崇高理想　新时代中国特色社会主义共同理想","content3":"D:共产主义崇高理想　中国特色社会主义共同理想","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":59,"examinationId":"45","questionId":2813,"title":"要坚持党管干部原则，_____，把好干部标准落到实处。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:坚持立场坚定、素质过硬，坚持五湖四海、任人唯贤，坚持事业为上、公道正派","content1":"B:坚持德才兼备、以德为先，坚持立场坚定、素质过硬，坚持事业为上、公道正派","content2":"C:坚持德才兼备、以德为先，坚持五湖四海、任人唯贤，坚持立场坚定、素质过硬","content3":"D:坚持德才兼备、以德为先，坚持五湖四海、任人唯贤，坚持事业为上、公道正派","content4":"E:","content5":"F:","answer":"D","score":"1","value":"","data":""},{"id":60,"examinationId":"45","questionId":2814,"title":"要以提升____为重点，突出政治功能，把企业、农村、机关、学校、科研院所、街道社区、社会组织等基层党组织建设成为宣传党的主张、贯彻党的决定、领导基层治理、团结动员群众、推动改革发展的坚强战斗堡垒。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:凝聚力","content1":"B:领导力","content2":"C:组织力","content3":"D:战斗力","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":61,"examinationId":"45","questionId":2815,"title":"要坚持无禁区、全覆盖、零容忍，坚持_______，坚持受贿行贿一起查，坚决防止党内形成利益集团。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:重预防、强高压、长震慑","content1":"B:重遏制、强高压、长震慑","content2":"C:重遏制、不减压、长震慑","content3":"D:重遏制、强高压、长威慑","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":62,"examinationId":"45","questionId":2816,"title":"增强党自我净化能力，根本靠强化____和____。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:党的自我监督　舆论监督","content1":"B:党的自我监督　群众监督","content2":"C:党的自我监督　司法监督","content3":"D:党的自我监督　民主监督","content4":"E:","content5":"F:","answer":"B","score":"1","value":"","data":""},{"id":63,"examinationId":"45","questionId":2817,"title":"推进_____，建设覆盖纪检监察系统的检举举报平台。强化不敢腐的震慑，扎牢不能腐的笼子，增强不想腐的自觉，通过不懈努力换来海晏河清、朗朗乾坤。\r\n\r\n","typeId":4,"typeName":"单选题","content0":"A:监察领域国家立法","content1":"B:预防腐败国家立法","content2":"C:反腐败国家立法","content3":"D:廉政国家立法","content4":"E:","content5":"F:","answer":"C","score":"1","value":"","data":""},{"id":64,"examinationId":"45","questionId":2818,"title":"全党同志一定要永远与人民____、____、____，永远把人民对美好生活的向往作为奋斗目标，以永不懈怠的精神状态和一往无前的奋斗姿态，继续朝着实现中华民族伟大复兴的宏伟目标奋勇前进。\n","typeId":3,"typeName":"多选题","content0":"A:同呼吸","content1":"B:共命运","content2":"C:手牵手","content3":"D:心连心","content4":"E:","content5":"F:","answer":"A,B,D","score":"1","value":"","data":""},{"id":65,"examinationId":"45","questionId":2819,"title":"过去五年，开放型经济新体制逐步健全，____、____、____稳居世界前列。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:对外贸易","content1":"B:对外投资","content2":"C:外汇储备","content3":"D:外汇支出","content4":"E:","content5":"F:","answer":"A,B,C","score":"1","value":"","data":""},{"id":66,"examinationId":"45","questionId":2820,"title":"科学立法、严格执法、公正司法、全民守法深入推进，____、____、____建设相互促进，中国特色社会主义法治体系日益完善，全社会法治观念明显增强。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:法治生活　","content1":"B:法治国家","content2":"C:法治政府","content3":"D:法治社会","content4":"E:","content5":"F:","answer":"B,C,D","score":"1","value":"","data":""},{"id":67,"examinationId":"45","questionId":2821,"title":"引导应对气候变化国际合作，成为全球生态文明建设的重要____、____、____。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:参与者","content1":"B:贡献者","content2":"C:引领者　","content3":"D:领导者","content4":"E:","content5":"F:","answer":"A,B,C","score":"1","value":"","data":""},{"id":68,"examinationId":"45","questionId":2822,"title":"出台中央八项规定，严厉整治____、____、____和____，坚决反对特权。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:形式主义","content1":"B:官僚主义","content2":"C:享乐主义","content3":"D:奢靡之风","content4":"E:个人主义","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":69,"examinationId":"45","questionId":2823,"title":"五年来，我们勇于面对党面临的重大风险考验和党内存在的突出问题，以顽强意志品质正风肃纪、反腐惩恶，消除了党和国家内部存在的严重隐患，党内政治生活气象更新，党内政治生态明显好转，党的_______显著增强。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:创造力","content1":"B:创新力","content2":"C:凝聚力","content3":"D:战斗力","content4":"E:","content5":"F:","answer":"A,C,D","score":"1","value":"","data":""},{"id":70,"examinationId":"45","questionId":2824,"title":"坚持______的要求，开展党的群众路线教育实践活动和\u201c三严三实\u201d专题教育，推进\u201c两学一做\u201d学习教育常态化制度化，全党理想信念更加坚定、党性更加坚强。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:照镜子","content1":"B:正衣冠","content2":"C:洗洗澡","content3":"D:治治病","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":71,"examinationId":"45","questionId":2825,"title":"这个新时代，是____。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:承前启后、继往开来、在新的历史条件下继续夺取中国特色社会主义伟大胜利的时代","content1":"B:决胜全面建成小康社会、进而全面建设社会主义现代化强国的时代","content2":"C:全国各族人民团结奋斗、不断创造美好生活、逐步实现全体人民共同富裕的时代","content3":"D:全体中华儿女勠力同心、奋力实现中华民族伟大复兴中国梦的时代","content4":"E:我国日益走近世界舞台中央、不断为人类作出更大贡献的时代","content5":"F:","answer":"A,B,C,D,E","score":"1","value":"","data":""},{"id":72,"examinationId":"45","questionId":2826,"title":"全党要更加自觉地增强____、____、____、____，既不走封闭僵化的老路，也不走改旗易帜的邪路，保持政治定力，坚持实干兴邦，始终坚持和发展中国特色社会主义。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:道路自信","content1":"B:理论自信","content2":"C:制度自信","content3":"D:文化自信　","content4":"E:思想自信","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":73,"examinationId":"45","questionId":2827,"title":"新时代中国特色社会主义思想，是_____，必须长期坚持并不断发展。\n","typeId":3,"typeName":"多选题","content0":"A:对马克思列宁主义、毛泽东思想、邓小平理论、\u201c三个代表\u201d重要思想、科学发展观的继承和发展","content1":"B:马克思主义中国化最新成果","content2":"C:党和人民实践经验和集体智慧的结晶","content3":"D:中国特色社会主义理论体系的重要组成部分","content4":"E:全党全国人民为实现中华民族伟大复兴而奋斗的行动指南","content5":"F:","answer":"A,B,C,D,E","score":"1","value":"","data":""},{"id":74,"examinationId":"45","questionId":2828,"title":"新时代坚持和发展中国特色社会主义的基本方略是____。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:坚持党对一切工作的领导，坚持以人民为中心，坚持全面深化改革","content1":"B:坚持新发展理念，坚持人民当家作主，坚持全面依法治国","content2":"C:坚持社会主义核心价值体系，坚持在发展中保障和改善民生，坚持人与自然和谐共生","content3":"D:坚持总体国家安全观，坚持党对人民军队的绝对领导，坚持\u201c一国两制\u201d和推进祖国统一","content4":"E:坚持推动构建人类命运共同体，坚持全面从严治党","content5":"F:","answer":"A,B,C,D,E","score":"1","value":"","data":""},{"id":75,"examinationId":"45","questionId":2829,"title":"党政军民学，东西南北中，党是领导一切的。必须增强____，自觉维护党中央权威和集中统一领导，自觉在思想上政治上行动上同党中央保持高度一致。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:政治意识　","content1":"B:大局意识","content2":"C:核心意识","content3":"D:看齐意识","content4":"E:纪律意识","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":76,"examinationId":"45","questionId":2830,"title":"建设一支____、____、____的人民军队，是实现\u201c两个一百年\u201d奋斗目标、实现中华民族伟大复兴的战略支撑。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:听党指挥","content1":"B:骁勇善战","content2":"C:能打胜仗","content3":"D:作风优良","content4":"E:","content5":"F:","answer":"A,C,D","score":"1","value":"","data":""},{"id":77,"examinationId":"45","questionId":2831,"title":"实施乡村振兴战略。______问题是关系国计民生的根本性问题，必须始终把解决好\u201c三农\u201d问题作为全党工作重中之重。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:农业","content1":"B:农村","content2":"C:农民","content3":"D:农田","content4":"E:","content5":"F:","answer":"A,B,C","score":"1","value":"","data":""},{"id":78,"examinationId":"45","questionId":2832,"title":"巩固和发展爱国统一战线。坚持______，支持民主党派按照中国特色社会主义参政党要求更好履行职能。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:长期共存","content1":"B:互相监督","content2":"C:肝胆相照","content3":"D:荣辱与共","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":79,"examinationId":"45","questionId":2833,"title":"提高就业质量和人民收入水平，鼓励勤劳守法致富，就要____。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:扩大中等收入群体","content1":"B:增加低收入者收入","content2":"C:调节过高收入","content3":"D:取缔非法收入","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":80,"examinationId":"45","questionId":2834,"title":"加强社会保障体系建设。坚持房子是用来住的、不是用来炒的定位，加快建立______的住房制度，让全体人民住有所居。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:多主体供给","content1":"B:多渠道保障","content2":"C:租购并举","content3":"D:多部门监管","content4":"E:","content5":"F:","answer":"A,B,C","score":"1","value":"","data":""},{"id":81,"examinationId":"45","questionId":2835,"title":"加强社会治理制度建设，完善党委领导、政府负责、社会协同、公众参与、法治保障的社会治理体制，提高社会治理________水平。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:社会化","content1":"B:法治化","content2":"C:智能化","content3":"D:专业化","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":82,"examinationId":"45","questionId":2836,"title":"必须坚持____、____、____为主的方针，形成节约资源和保护环境的空间格局、产业结构、生产方式、生活方式，还自然以宁静、和谐、美丽。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:事先预防","content1":"B:节约优先","content2":"C:保护优先","content3":"D:自然恢复","content4":"E:","content5":"F:","answer":"B,C,D","score":"1","value":"","data":""},{"id":83,"examinationId":"45","questionId":2837,"title":"构建市场导向的绿色技术创新体系，发展绿色金融，壮大____、____、____。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:节能环保产业","content1":"B:清洁生产产业","content2":"C:绿色科技产业","content3":"D:清洁能源产业","content4":"E:","content5":"F:","answer":"A,B,D","score":"1","value":"","data":""},{"id":84,"examinationId":"45","questionId":2838,"title":"倡导简约适度、绿色低碳的生活方式，反对奢侈浪费和不合理消费，开展创建节约型机关、_____、_____、_____、_____等行动。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:绿色家庭","content1":"B:绿色学校　","content2":"C:绿色社区","content3":"D:绿色城市","content4":"E:绿色出行","content5":"F:","answer":"A,B,C,E","score":"1","value":"","data":""},{"id":85,"examinationId":"45","questionId":2839,"title":"提高污染排放标准，强化排污者责任，健全_______、_______、______等制度。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:环保信用评价","content1":"B:污染企业备案","content2":"C:信息强制性披露","content3":"D:严惩重罚","content4":"E:","content5":"F:","answer":"A,C,D","score":"1","value":"","data":""},{"id":86,"examinationId":"45","questionId":2840,"title":"完成_____、_____、_____三条控制线划定工作。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:生态保护红线","content1":"B:永久基本农田","content2":"C:城镇开发边界","content3":"D:国土绿化面积","content4":"E:","content5":"F:","answer":"A,B,C","score":"1","value":"","data":""},{"id":87,"examinationId":"45","questionId":2841,"title":"保持香港、澳门长期繁荣稳定，必须全面准确贯彻____的方针。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:\u201c一国两制\u201d","content1":"B:\u201c港人治港\u201d","content2":"C:\u201c澳人治澳\u201d","content3":"D:\u201c高度自治\u201d","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":88,"examinationId":"45","questionId":2842,"title":"要支持香港、澳门融入国家发展大局，以____、____、____等为重点，全面推进内地同香港、澳门互利合作。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:粤港澳大湾区建设","content1":"B:粤港澳合作","content2":"C:粤港澳政府合作","content3":"D:泛珠三角区域合作","content4":"E:","content5":"F:","answer":"A,B,D","score":"1","value":"","data":""},{"id":89,"examinationId":"45","questionId":2843,"title":"中国将高举___、___、___、___的旗帜，恪守维护世界和平、促进共同发展的外交政策宗旨。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:和平","content1":"B:发展　","content2":"C:合作","content3":"D:共赢","content4":"E:互惠","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":90,"examinationId":"45","questionId":2844,"title":"坚定不移在和平共处五项原则基础上发展同各国的友好合作，推动建设____、____、____的新型国际关系。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:相互尊重","content1":"B:公平正义","content2":"C:互不干涉","content3":"D:合作共赢","content4":"E:","content5":"F:","answer":"A,B,D","score":"1","value":"","data":""},{"id":91,"examinationId":"45","questionId":2845,"title":"世界正处于大发展大变革大调整时期，和平与发展仍然是时代主题。____、____、____、____深入发展。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:世界多极化","content1":"B:经济全球化","content2":"C:社会信息化","content3":"D:文化多样化","content4":"E:治理民主化","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":92,"examinationId":"45","questionId":2846,"title":"积极促进\u201c一带一路\u201d国际合作，努力实现____、____、____、____、____，打造国际合作新平台，增添共同发展新动力。\n\n","typeId":3,"typeName":"多选题","content0":"A:政策沟通","content1":"B:设施联通","content2":"C:贸易畅通","content3":"D:人员互通","content4":"E:资金融通","content5":"F:民心相通","answer":"A;B;C;E;F","score":"1","value":"","data":"","pic":""},{"id":93,"examinationId":"45","questionId":2847,"title":"要深刻认识党面临的____的长期性和复杂性。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:执政考验","content1":"B:改革开放考验","content2":"C:市场经济考验","content3":"D:生态保护考验","content4":"E:外部环境考验","content5":"F:","answer":"A,B,C,E","score":"1","value":"","data":""},{"id":94,"examinationId":"45","questionId":2848,"title":"新时代党的建设总要求是____________。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:坚持和加强党的全面领导，坚持党要管党、全面从严治党","content1":"B:以加强党的长期执政能力建设、先进性和纯洁性建设为主线，以党的政治建设为统领，以坚定理想信念宗旨为根基","content2":"C:全面推进党的政治建设、思想建设、组织建设、作风建设、纪律建设","content3":"D:把制度建设贯穿其中，深入推进反腐败斗争，不断提高党的建设质量","content4":"E:把党建设成为始终走在时代前列、人民衷心拥护、勇于自我革命、经得起各种风浪考验、朝气蓬勃的马克思主义执","content5":"F:","answer":"A,B,C,D,E","score":"1","value":"","data":""},{"id":95,"examinationId":"45","questionId":2849,"title":"领导十三亿多人的社会主义大国，我们党既要政治过硬，也要本领高强。要_______。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:增强学习本领，增强政治领导本领","content1":"B:增强改革创新本领，增强科学发展本领","content2":"C:增强依法执政本领，增强群众工作本领","content3":"D:增强狠抓落实本领，增强驾驭风险本领","content4":"E:","content5":"F:","answer":"A,B,C,D","score":"1","value":"","data":""},{"id":96,"examinationId":"45","questionId":2850,"title":"以____、____、____、____、____，把党内和党外、国内和国外各方面优秀人才集聚到党和人民的伟大奋斗中来。\n\n","typeId":3,"typeName":"多选题","content0":"A:识才的慧眼","content1":"B:敬才的风度","content2":"C:爱才的诚意","content3":"D:用才的胆识","content4":"E:容才的雅量","content5":"F:聚才的良方","answer":"A;C;D;E;F","score":"1","value":"","data":"","pic":""},{"id":97,"examinationId":"45","questionId":2851,"title":"青年兴则国家兴，青年强则国家强。青年一代____、____、____，国家就有前途，民族就有希望。\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:有品德","content1":"B:有理想","content2":"C:有本领","content3":"D:有担当","content4":"E:","content5":"F:","answer":"B,C,D","score":"1","value":"","data":""},{"id":98,"examinationId":"45","questionId":2852,"title":"全党全国各族人民要紧密团结在党中央周围，高举中国特色社会主义伟大旗帜，锐意进取，埋头苦干，为实现推进现代化建设、完成祖国统一、维护世界和平与促进共同发展三大历史任务，为___________继续奋斗！\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:决胜全面建成小康社会","content1":"B:夺取新时代中国特色社会主义伟大胜利","content2":"C:全面建成社会主义现代化强国","content3":"D:实现中华民族伟大复兴的中国梦","content4":"E:实现人民对美好生活的向往","content5":"F:","answer":"A,B,D,E","score":"1","value":"","data":""},{"id":99,"examinationId":"45","questionId":2853,"title":"5年来，以习近平同志为核心的党中央带领全党全军全国各族人民，开创了中国特色社会主义伟大事业和党的建设新的伟大工程新局面，我国社会主义现代化建设形成了__ 、__  、__  、__ 、__\u201c五位一体\u201d的总体布局.\r\n\r\n","typeId":3,"typeName":"多选题","content0":"A:经济建设","content1":"B:政治建设","content2":"C:文化建设","content3":"D:生态文明建设","content4":"E:社会建设","content5":"F:","answer":"A,B,C,D,E","score":"1","value":"","data":""},{"id":100,"examinationId":"45","questionId":2931,"title":"5年来，以习近平同志为核心的党中央带领全党全军全国各族人民，开创了中国特色社会主义伟大事业和党的建设新的伟大工程新局面，我国社会主义现代化建设形成了\u201c五位一体\u201d的总体布局，党和国家的工作形成__ 、__、__、__\u201c四个全面\u201d的战略布局","typeId":3,"typeName":"多选题","content0":"A:全面建成小康社会","content1":"B:全面深化改革","content2":"C:全面依法治国","content3":"D:全面从严治党","answer":"A;B;C;D","score":"1","value":"","data":"","pic":""}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * examinationId : 45
         * questionId : 2755
         * title : 中国共产党第十九次全国代表大会，是在全面建成小康社会决胜阶段、中国特色社会主义进入_____的关键时期召开的一次十分重要的大会。

         * typeId : 4
         * typeName : 单选题
         * content0 : A:新时期
         * content1 : B:新阶段
         * content2 : C:新征程
         * content3 : D:新时代
         * content4 : E:
         * content5 : F:
         * answer : D
         * score : 1
         * value :
         * data :
         * pic :
         */

        private int id;
        private String examinationId;
        private int questionId;
        private String title;
        private int typeId;
        private String typeName;
        private String content0;
        private String content1;
        private String content2;
        private String content3;
        private String content4;
        private String content5;
        private String answer;
        private String score;
        private String value;
        private String data;
        private String pic;
        private String oldScore;

        public String getOldScore() {
            return oldScore;
        }

        public void setOldScore(String oldScore) {
            this.oldScore = oldScore;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getExaminationId() {
            return examinationId;
        }

        public void setExaminationId(String examinationId) {
            this.examinationId = examinationId;
        }

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(int questionId) {
            this.questionId = questionId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getContent0() {
            return content0;
        }

        public void setContent0(String content0) {
            this.content0 = content0;
        }

        public String getContent1() {
            return content1;
        }

        public void setContent1(String content1) {
            this.content1 = content1;
        }

        public String getContent2() {
            return content2;
        }

        public void setContent2(String content2) {
            this.content2 = content2;
        }

        public String getContent3() {
            return content3;
        }

        public void setContent3(String content3) {
            this.content3 = content3;
        }

        public String getContent4() {
            return content4;
        }

        public void setContent4(String content4) {
            this.content4 = content4;
        }

        public String getContent5() {
            return content5;
        }

        public void setContent5(String content5) {
            this.content5 = content5;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
